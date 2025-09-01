package a09jwt.service;



import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) {
        // Static user: "user" / "password"
        return new User("user", "{noop}password", Collections.emptyList());
    }
}
