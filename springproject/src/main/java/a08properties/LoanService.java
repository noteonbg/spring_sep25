package a08properties;

public class LoanService {

    private double maxLoanAmount;
    private double minLoanAmount;
    private double interestRate;
    private int loanTerm;

    // Constructor-based injection
    public LoanService(double maxLoanAmount, double minLoanAmount, double interestRate, int loanTerm) {
        this.maxLoanAmount = maxLoanAmount;
        this.minLoanAmount = minLoanAmount;
        this.interestRate = interestRate;
        this.loanTerm = loanTerm;
    }

    // Method to calculate the total amount to be paid on the loan
    public double calculateLoanAmount(double principalAmount) {
        if (principalAmount < minLoanAmount || principalAmount > maxLoanAmount) {
            throw new IllegalArgumentException("Loan amount out of allowed range.");
        }

        double interest = (principalAmount * interestRate * loanTerm) / 100;
        return principalAmount + interest;
    }

    @Override
    public String toString() {
        return "LoanService [maxLoanAmount=" + maxLoanAmount + ", minLoanAmount=" + minLoanAmount
                + ", interestRate=" + interestRate + "%, loanTerm=" + loanTerm + " years]";
    }
}
