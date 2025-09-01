package a07stereotypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    private final LoanRepository loanRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    // Business logic to calculate total amount to be paid
    public double calculateLoanAmount(Loan loan) {
        double interest = (loan.getPrincipalAmount() * loan.getInterestRate() * loan.getLoanTerm()) / 100;
        return loan.getPrincipalAmount() + interest;
    }

    // Simulate saving a loan (in a real application, this would interact with the database)
    public void saveLoan(Loan loan) {
        loanRepository.saveLoan(loan);
    }
}

