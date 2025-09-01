package a09qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("personalLoan")
public class PersonalLoanInterestCalculator implements LoanInterestCalculator {

    @Override
    public double calculateInterest(double principalAmount, double interestRate, int loanTerm) {
        // Simple interest formula for personal loans
        return (principalAmount * interestRate * loanTerm) / 100;
    }
}

