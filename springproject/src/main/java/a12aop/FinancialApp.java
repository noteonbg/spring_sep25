package a12aop;



import a12aop.config.AppConfig;
import a12aop.model.Loan;
import a12aop.service.LoanService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FinancialApp {

    public static void main(String[] args) {
        // Load Spring context from AppConfig (AOP configuration)
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {

            // Retrieve LoanService bean from the context
            LoanService loanService = context.getBean(LoanService.class);

            // Create a new loan
            Loan newLoan = new Loan(0, "Home Loan", 500000, 6.5, 20);
            loanService.createLoan(newLoan);

            // Update loan details
            newLoan.setLoanType("Updated Home Loan");
            loanService.updateLoan(newLoan);

            // Get loan by ID
            loanService.getLoanById(1);

            // Delete loan by ID
            loanService.deleteLoan(1);
        }
    }
}

