package a09qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    private final LoanInterestCalculator loanInterestCalculator;

    @Autowired
    public LoanService(@Qualifier("homeLoan") LoanInterestCalculator loanInterestCalculator) {
        this.loanInterestCalculator = loanInterestCalculator;
    }

    public double calculateLoanAmount(double principalAmount, double interestRate, int loanTerm) {
        double interest = loanInterestCalculator.calculateInterest(principalAmount, interestRate, loanTerm);
        return principalAmount + interest;
    }
}
