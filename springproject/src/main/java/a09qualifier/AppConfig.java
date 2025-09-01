package a09qualifier;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "a09qualifier")  // Adjust base package as needed
public class AppConfig {
    // Spring will automatically scan for beans annotated with @Component, @Service, etc.
}
