package a05lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.DisposableBean;


public class Loan implements InitializingBean, DisposableBean {

    private double principalAmount;
    private double interestRate;
    private int loanTerm; // In years

    public Loan(double principalAmount, double interestRate, int loanTerm) {
        this.principalAmount = principalAmount;
        this.interestRate = interestRate;
        this.loanTerm = loanTerm;
    }

    // Getter and Setter for principalAmount, interestRate, and loanTerm
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

    // Initialize method called after properties are set
    @PostConstruct
    public void init() {
        System.out.println("Loan Bean initialized with principal: " + principalAmount + ", interest rate: " + interestRate + ", term: " + loanTerm + " years.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Loan instance created and properties set.");
    }

    // Destroy method called when bean is destroyed
    @PreDestroy
    public void destroy() {
        System.out.println("Loan Bean is being destroyed.");
    }


    // Method to calculate loan amount after interest
    public double calculateTotalAmount() {
        double interest = (principalAmount * interestRate * loanTerm) / 100;
        return principalAmount + interest;
    }

    @Override
    public String toString() {
        return "Loan {principalAmount=" + principalAmount + ", interestRate=" + interestRate + ", loanTerm=" + loanTerm + "}";
    }
}

/*

Bean Scopes in Spring

Spring supports the following bean scopes:
Singleton (default scope): Only one instance of the bean is created for the entire Spring container.
Prototype: A new bean instance is created each time the bean is requested.
Request: A bean is created for each HTTP request (typically used in web applications).
Session: A bean is created for each HTTP session (also used in web applications).

Global Session: A bean is created for each global HTTP session (used in portlet-based applications).

We'll demonstrate Singleton and Prototype scopes, as these are the most commonly used.

2. Bean Lifecycle

The lifecycle of a Spring bean can be divided into several phases:

Instantiation: Spring creates the bean.
Populating properties: Spring injects the required dependencies (via @Autowired or setter injection).
Initializing: Spring calls initialization methods, either annotated with @PostConstruct or specified in configuration.
Destruction: Spring calls destruction methods, either annotated with @PreDestroy or specified in configuration.
 */