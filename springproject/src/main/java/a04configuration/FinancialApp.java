package a04configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FinancialApp {

    public static void main(String[] args) {
        // Create Spring context with the AppConfig class
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            // Retrieve beans from the Spring context
            LoanService loanService = context.getBean(LoanService.class);
            LoanReport loanReport = context.getBean(LoanReport.class);

            // Example data for loan calculation
            double principal = 50000;
            double rate = 5;  // 5% annual interest rate
            int years = 10;

            // Calculate interest
            double interest = loanService.calculateInterest(principal, rate, years);

            // Generate loan report for customer with ID 1
            loanReport.generateReport(1, principal, interest);
        }
    }
}


/*
@Configuration: Marks a class as a source of bean definitions.
@Bean: Used to define individual beans that will be managed by the Spring container.
AnnotationConfigApplicationContext: This class loads the configuration class and allows access to beans.
 */
