package a07stereotypes;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "a07stereotypes")  // Adjust base package as needed
public class AppConfig {
    // Spring will automatically scan and register beans annotated with @Component, @Service, @Controller, and @Repository
}
