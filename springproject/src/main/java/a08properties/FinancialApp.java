package a08properties;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FinancialApp {

    public static void main(String[] args) {
        // Load the Spring context from the configuration class
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FinancialConfig.class)) {

            // Retrieve LoanService bean
            LoanService loanService = context.getBean(LoanService.class);

            // Example: Calculate loan amount for a principal of 100,000
            double principalAmount = 100000;
            double totalAmount = loanService.calculateLoanAmount(principalAmount);

            System.out.println("Loan Details:");
            System.out.println(loanService);
            System.out.println("Total amount to be paid for principal of " + principalAmount + ": " + totalAmount);
        }
    }
}
