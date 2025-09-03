package a11freak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("a12junk")
@SpringBootApplication
public class SbBootApp {
    public static void main(String[] args) {

        SpringApplication.run(SbBootApp.class,args);
    }
}
