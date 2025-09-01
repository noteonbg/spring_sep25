package a06messageresourcesevents;

import org.springframework.context.ApplicationEvent;

public class LoanApprovalEvent extends ApplicationEvent {

    private final String loanType;

    public LoanApprovalEvent(Object source, String loanType) {
        super(source);
        this.loanType = loanType;
    }

    public String getLoanType() {
        return loanType;
    }
}
