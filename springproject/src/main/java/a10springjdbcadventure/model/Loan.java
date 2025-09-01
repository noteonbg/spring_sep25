package a10springjdbcadventure.model;



public class Loan {
    private int id;
    private String loanType;
    private double principalAmount;
    private double interestRate;
    private int loanTerm;

    public Loan()
    {

    }
    // Constructor
    public Loan(int id, String loanType, double principalAmount, double interestRate, int loanTerm) {
        this.id = id;
        this.loanType = loanType;
        this.principalAmount = principalAmount;
        this.interestRate = interestRate;
        this.loanTerm = loanTerm;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
        return "Loan [id=" + id + ", loanType=" + loanType + ", principalAmount=" + principalAmount +
                ", interestRate=" + interestRate + ", loanTerm=" + loanTerm + "]";
    }
}

