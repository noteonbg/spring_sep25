package a07stereotypes;

import org.springframework.stereotype.Component;

@Component
public class Loan {

    private String loanType;
    private double principalAmount;
    private double interestRate;
    private int loanTerm;

    public Loan()
    {

    }

    // Constructor
    public Loan(String loanType, double principalAmount, double interestRate, int loanTerm) {
        this.loanType = loanType;
        this.principalAmount = principalAmount;
        this.interestRate = interestRate;
        this.loanTerm = loanTerm;
    }

    // Getters and setters
    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public double getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(double principalAmount) {
        this.principalAmount = principalAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanType='" + loanType + '\'' +
                ", principalAmount=" + principalAmount +
                ", interestRate=" + interestRate +
                ", loanTerm=" + loanTerm +
                '}';
    }
}
