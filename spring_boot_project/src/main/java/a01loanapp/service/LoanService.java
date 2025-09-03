package a01loanapp.service;



import a01loanapp.model.Loan;
import a01loanapp.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public List<Loan> getAllLoans() {

        System.out.println("get all loans of service");
        return loanRepository.findAll();
    }

    public Optional<Loan> getLoanById(Long id) {
        return loanRepository.findById(id);
    }

    public Loan createLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public Loan updateLoan(Long id, Loan loanDetails) {
        return loanRepository.findById(id)
                .map(loan -> {
                    loan.setLoanType(loanDetails.getLoanType());
                    loan.setPrincipalAmount(loanDetails.getPrincipalAmount());
                    loan.setInterestRate(loanDetails.getInterestRate());
                    loan.setLoanTerm(loanDetails.getLoanTerm());
                    return loanRepository.save(loan);
                })
                .orElseThrow(() -> new RuntimeException("Loan not found with id " + id));
    }

    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }
}
