package a07security.config;




import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.configurationSource(request -> {
                    CorsConfiguration config = new CorsConfiguration();
                    config.setAllowedOrigins(List.of("http://localhost:3000"));
                    config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
                    config.setAllowedHeaders(List.of("*"));
                    config.setAllowCredentials(true); // allow cookies (e.g., for session-based auth)
                    return config;
                }));

        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/add").authenticated()
                        .requestMatchers("/api/multiply").permitAll()
                )
                .httpBasic(Customizer.withDefaults())  // Enable Basic Auth
                .csrf(AbstractHttpConfigurer::disable); // For simplicity in API testing

        return http.build();
    }
}


