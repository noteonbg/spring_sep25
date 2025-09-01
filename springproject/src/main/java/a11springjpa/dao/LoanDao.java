package a11springjpa.dao;



import a11springjpa.model.Loan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.springframework.dao.DataIntegrityViolationException;



@Repository
public class LoanDao {

    private static final Logger logger = LoggerFactory.getLogger(LoanDaoWithTransactions.class);

    @PersistenceContext
    private EntityManager entityManager;

    // Create (Insert) a new loan
    @Transactional
    public void createLoan(Loan loan) {
        try {
            logger.debug("Creating loan: {}", loan);
            entityManager.persist(loan); // Persist the loan entity
            logger.info("Loan created with ID: {}", loan.getId());
        } catch (DataIntegrityViolationException e) {
            logger.error("Error occurred while creating loan: Data Integrity Violation", e);
            throw e; // Rethrow for transaction rollback
        } catch (Exception e) {
            logger.error("Unexpected error while creating loan", e);
            throw new RuntimeException("Unexpected error while creating loan", e); // Rethrow for transaction rollback
        }
    }

    // Read (Get) a loan by ID
    public Loan getLoanById(int id) {
        try {
            logger.debug("Retrieving loan with ID: {}", id);
            Loan loan = entityManager.find(Loan.class, id);
            if (loan == null) {
                throw new EntityNotFoundException("Loan with ID " + id + " not found.");
            }
            logger.info("Retrieved loan: {}", loan);
            return loan;
        } catch (EntityNotFoundException e) {
            logger.error("Loan not found for ID: {}", id, e);
            throw e; // Rethrow for proper handling in the service layer
        } catch (Exception e) {
            logger.error("Unexpected error while retrieving loan with ID: {}", id, e);
            throw new RuntimeException("Unexpected error while retrieving loan", e); // Rethrow for transaction rollback
        }
    }

    // Update loan details
    @Transactional
    public void updateLoan(Loan loan) {
        try {
            logger.debug("Updating loan with ID: {}", loan.getId());
            if (loan.getId() == 0) {
                throw new IllegalArgumentException("Loan ID must be provided for update.");
            }
            entityManager.merge(loan); // Update the loan entity
            logger.info("Updated loan with ID: {}", loan.getId());
        } catch (IllegalArgumentException e) {
            logger.error("Invalid loan ID for update: {}", loan.getId(), e);
            throw e; // Propagate invalid argument exception
        } catch (Exception e) {
            logger.error("Unexpected error while updating loan", e);
            throw new RuntimeException("Unexpected error while updating loan", e); // Rethrow for transaction rollback
        }
    }

    // Delete a loan by ID
    @Transactional
    public void deleteLoan(int id) {
        try {
            Loan loan = entityManager.find(Loan.class, id);
            if (loan == null) {
                throw new EntityNotFoundException("Loan with ID " + id + " not found.");
            }
            logger.debug("Deleting loan with ID: {}", id);
            entityManager.remove(loan); // Delete the loan entity
            logger.info("Deleted loan with ID: {}", id);
        } catch (EntityNotFoundException e) {
            logger.error("Loan not found for deletion, ID: {}", id, e);
            throw e; // Rethrow for proper handling in the service layer
        } catch (Exception e) {
            logger.error("Unexpected error while deleting loan", e);
            throw new RuntimeException("Unexpected error while deleting loan", e); // Rethrow for transaction rollback
        }
    }

    // Get all loans
    public List<Loan> getAllLoans() {
        try {
            logger.debug("Retrieving all loans.");
            List<Loan> loans = entityManager.createQuery("SELECT l FROM Loan l", Loan.class).getResultList();
            logger.info("Retrieved all loans: {}", loans);
            return loans;
        } catch (Exception e) {
            logger.error("Unexpected error while retrieving all loans", e);
            throw new RuntimeException("Unexpected error while retrieving all loans", e);
        }
    }
}

