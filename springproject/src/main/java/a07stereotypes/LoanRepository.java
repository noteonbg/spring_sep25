package a07stereotypes;

import org.springframework.stereotype.Repository;

@Repository
public class LoanRepository {

    // Simulate saving a loan
    public void saveLoan(Loan loan) {
        System.out.println("Saving loan: " + loan);
    }
}
