package a06messageresourcesevents;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

public class FinancialApp {

    public static void main(String[] args) {
        // Load the Spring context from Java-based configuration
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {

            // Retrieve LoanApprovalService bean
            LoanApprovalService loanApprovalService = context.getBean(LoanApprovalService.class);

            // Set the loan type and locale (English)
            String loanType = "Home Loan";
            Locale locale = Locale.ENGLISH;

            // Approve the loan, which will trigger the event and display messages
            loanApprovalService.approveLoan(loanType, locale);
        }
    }
}
