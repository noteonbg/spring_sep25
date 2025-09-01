package a07stereotypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LoanController {

    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    // Simulate an HTTP request to calculate and save a loan
    public void processLoan() {
        Loan loan = new Loan("Home Loan", 500000, 7.5, 20);  // Create a loan object
        double totalAmount = loanService.calculateLoanAmount(loan);  // Calculate total loan amount
        System.out.println("Total Loan Amount: " + totalAmount);

        loanService.saveLoan(loan);  // Save loan (simulating database interaction)
    }
}

