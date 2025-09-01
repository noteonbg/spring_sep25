package a09qualifier;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FinancialApp {

    public static void main(String[] args) {
        // Load the Spring context
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {

            // Retrieve the LoanService bean
            LoanService loanService = context.getBean(LoanService.class);

            // Example: Calculate loan amount for a principal of 100,000 with home loan interest
            double principalAmount = 100000;
            double interestRate = 6.5;
            int loanTerm = 20;

            // Calculate and display the total loan amount
            double totalAmount = loanService.calculateLoanAmount(principalAmount, interestRate, loanTerm);
            System.out.println("Total loan amount: " + totalAmount);
        }
    }
}

