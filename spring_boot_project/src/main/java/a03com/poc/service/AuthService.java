package a03com.poc.service;

import a03com.poc.dto.LoginInfo;
import a03com.poc.dto.RegisterInfo;
import a03com.poc.entity.Role;
import a03com.poc.entity.User;
import a03com.poc.repository.UserRepository;
import a03com.poc.config.JwtUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepo;
    private final PasswordEncoder pwdEncoder;
    private final JwtUtils jwtUtils;

    public AuthService(UserRepository userRepo, PasswordEncoder pwdEncoder, JwtUtils jwtUtils) {
        this.userRepo = userRepo;
        this.pwdEncoder = pwdEncoder;
        this.jwtUtils = jwtUtils;
    }

    public String register(RegisterInfo req) {
        if (userRepo.existsByUsername(req.getUsername()) || userRepo.existsByEmail(req.getEmail())) {
            throw new RuntimeException("Username or Email already in use");
        }
        User user = new User();
        user.setUsername(req.getUsername());
        user.setEmail(req.getEmail());
        user.setPassword(pwdEncoder.encode(req.getPassword()));
        user.setRole(Role.ROLE_USER);
        userRepo.save(user);
        return jwtUtils.generateToken(user.getUsername());
    }

    public String login(LoginInfo req) {
        User user = userRepo.findByUsername(req.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
        if (!pwdEncoder.matches(req.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return jwtUtils.generateToken(user.getUsername());
    }
}

