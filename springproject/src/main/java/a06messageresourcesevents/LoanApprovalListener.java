package a06messageresourcesevents;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class LoanApprovalListener {

    @EventListener
    public void handleLoanApprovalEvent(LoanApprovalEvent event) {
        System.out.println("Loan approval event received: Loan Type = " + event.getLoanType());
        // Further processing could be done here (e.g., sending emails, logging, etc.)
    }
}

