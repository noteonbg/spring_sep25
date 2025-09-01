package a12aop.service;



import a12aop.model.Loan;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    public Loan createLoan(Loan loan) {
        // Simulate loan creation logic
        System.out.println("Creating loan: " + loan);
        return loan;
    }

    public Loan updateLoan(Loan loan) {
        // Simulate loan update logic
        System.out.println("Updating loan: " + loan);
        return loan;
    }

    public void deleteLoan(int id) {
        // Simulate loan deletion logic
        System.out.println("Deleting loan with ID: " + id);
    }

    public Loan getLoanById(int id) {
        // Simulate retrieving a loan by ID
        Loan loan = new Loan(id, "Home Loan", 500000, 5.5, 20);
        System.out.println("Fetching loan: " + loan);
        return loan;
    }
}
