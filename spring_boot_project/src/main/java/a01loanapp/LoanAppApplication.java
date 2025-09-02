package a01loanapp;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LoanAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoanAppApplication.class, args);
    }
}


/*

@SpringBootApplication
public class X {

    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(X.class);
       // application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);

    }
}*/

