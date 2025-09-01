package a10springjdbcadventure;

import a10springjdbcadventure.config.AppConfig;
import a10springjdbcadventure.model.Loan;
import a10springjdbcadventure.service.LoanService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FinancialApp {

    public static void main(String[] args) {
        // Load the Spring context
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {

            // Retrieve LoanService bean
            LoanService loanService = context.getBean(LoanService.class);

            // Create a new loan
            Loan newLoan = new Loan(0, "Home Loan", 500000, 6.5, 20);
            loanService.createLoan(newLoan);

            // Get all loans
            System.out.println("All Loans:");
            loanService.getAllLoans().forEach(System.out::println);

            // Get loan by ID
            Loan loanById = loanService.getLoanById(1);
            System.out.println("Loan by ID: " + loanById);

            // Update loan
            loanById.setLoanType("Updated Home Loan");
            loanService.updateLoan(loanById);

            // Delete loan by ID
            loanService.deleteLoan(1);

            // Get all loans after deletion
            System.out.println("All Loans After Deletion:");
            loanService.getAllLoans().forEach(System.out::println);



        }
    }
}
