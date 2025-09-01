package a11springjpa.model;

import jakarta.persistence.*;

@Table(name="JpaLoan")
@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment primary key
    private int id;

    @Column(name = "loan_type")
    private String loanType;

    @Column(name = "principal_amount")
    private double principalAmount;

    @Column(name = "interest_rate")
    private double interestRate;

    @Column(name = "loan_term")
    private int loanTerm;

    // Getters and Setters

    public Loan() {
    }

    public Loan(int id, String loanType, double principalAmount, double interestRate, int loanTerm) {
        this.id = id;
        this.loanType = loanType;
        this.principalAmount = principalAmount;
        this.interestRate = interestRate;
        this.loanTerm = loanTerm;
    }

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
        return "Loan{" +
                "id=" + id +
                ", loanType='" + loanType + '\'' +
                ", principalAmount=" + principalAmount +
                ", interestRate=" + interestRate +
                ", loanTerm=" + loanTerm +
                '}';
    }
}
