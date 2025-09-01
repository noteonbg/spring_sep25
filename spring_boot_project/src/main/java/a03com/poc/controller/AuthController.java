package a03com.poc.controller;



import a03com.poc.dto.LoginInfo;
import a03com.poc.dto.RegisterInfo;
import a03com.poc.service.AuthService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService) { this.authService = authService; }

    @SecurityRequirement(name = "bearerAuth")
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterInfo req) {
        String token = authService.register(req);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginInfo req) {
        String token = authService.login(req);
        return ResponseEntity.ok(token);
    }
}
