package a06messageresourcesevents;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@ComponentScan("a06messageresourcesevents")
@Configuration
public class AppConfig {

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("messages");  // File base name (without the .properties)
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
