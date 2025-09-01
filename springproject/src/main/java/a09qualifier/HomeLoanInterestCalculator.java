package a09qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("homeLoan")
public class HomeLoanInterestCalculator implements LoanInterestCalculator {

    @Override
    public double calculateInterest(double principalAmount, double interestRate, int loanTerm) {
        // Simple interest formula: Interest = (P * R * T) / 100
        return (principalAmount * interestRate * loanTerm) / 100;
    }
}
