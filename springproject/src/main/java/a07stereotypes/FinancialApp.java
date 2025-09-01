package a07stereotypes;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FinancialApp {

    public static void main(String[] args) {
        // Load the Spring context from the AppConfig class
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {

            // Retrieve the LoanController bean and simulate loan processing
            LoanController loanController = context.getBean(LoanController.class);
            loanController.processLoan();
        }
    }
}
