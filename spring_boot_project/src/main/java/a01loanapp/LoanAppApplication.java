package a01loanapp;



import a01loanapp.model.Loan;
import a01loanapp.repository.LoanRepository;
import a01loanapp.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;


@SpringBootApplication
public class LoanAppApplication  implements CommandLineRunner
{
    public static void main(String[] args) {
        SpringApplication.run(LoanAppApplication.class, args);
    }

    //@Autowired
   // private String s1;


    public void run(String... args) throws Exception {

        System.out.println("run method please walk also");
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

