package a06messageresourcesevents;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class LoanApprovalService {

    private final MessageSource messageSource;
    private final ApplicationEventPublisher eventPublisher;

    public LoanApprovalService(MessageSource messageSource, ApplicationEventPublisher eventPublisher) {
        this.messageSource = messageSource;
        this.eventPublisher = eventPublisher;
    }

    public String approveLoan(String loanType, Locale locale) {
        // Send the approval message
        String message = messageSource.getMessage("loan.approved", new Object[]{loanType}, locale);
        System.out.println(message);

        // Trigger the loan approval event
        LoanApprovalEvent event = new LoanApprovalEvent(this, loanType);
        eventPublisher.publishEvent(event);

        return message;
    }
}
