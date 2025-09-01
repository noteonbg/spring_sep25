package a10springjdbcadventure.service;



import a10springjdbcadventure.dao.LoanDao;
import a10springjdbcadventure.model.Loan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    private LoanDao loanDao;

    // Constructor to inject LoanDao
    public LoanService(LoanDao loanDao) {
        this.loanDao = loanDao;
    }

    // Create loan
    public void createLoan(Loan loan) {
        loanDao.createLoan(loan);
    }

    // Get loan by ID
    public Loan getLoanById(int id) {
        return loanDao.getLoanById(id);
    }

    // Update loan
    public void updateLoan(Loan loan) {
        loanDao.updateLoan(loan);
    }

    // Delete loan by ID
    public void deleteLoan(int id) {
        loanDao.deleteLoan(id);
    }

    // Get all loans
    public List<Loan> getAllLoans() {
        return loanDao.getAllLoans();
    }
}

