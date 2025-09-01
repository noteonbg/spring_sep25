package a12aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy  // Enables AspectJ proxying
@ComponentScan(basePackages = "a12aop")
public class AppConfig {

    // Additional beans can go here if needed
}

