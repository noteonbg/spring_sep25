package a10springjdbcadventure.dao;



import a10springjdbcadventure.model.Loan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoanDao {

    private JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(LoanDao.class);

    // Constructor to inject JdbcTemplate
    public LoanDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Create (Insert) a new loan
    public void createLoan(Loan loan) {
        String sql = "INSERT INTO loans (loan_type, principal_amount, interest_rate, loan_term) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, loan.getLoanType(), loan.getPrincipalAmount(), loan.getInterestRate(), loan.getLoanTerm());
        logger.info("Loan created with type: {}", loan.getLoanType());
    }

    // Read (Get) a loan by ID
    public Loan getLoanById(int id) {
        String sql = "SELECT * FROM loans WHERE id = ?";
        Loan loan = new Loan();
        try {
            loan = jdbcTemplate.queryForObject(sql, new Object[]{id}, loanRowMapper());
        } catch (EmptyResultDataAccessException e) {
            logger.info("got an error",e);
        }
        logger.info("Retrieved loan: {}", loan); // Log info message after retrieving the loan
        return loan;
    }

    // Update loan details
    public void updateLoan(Loan loan) {
        String sql = "UPDATE loans SET loan_type = ?, principal_amount = ?, interest_rate = ?, loan_term = ? WHERE id = ?";
        jdbcTemplate.update(sql, loan.getLoanType(), loan.getPrincipalAmount(), loan.getInterestRate(),
                loan.getLoanTerm(), loan.getId());
        logger.info("Updated loan with id: {}", loan.getId());
    }

    // Delete a loan by ID
    public void deleteLoan(int id) {
        String sql = "DELETE FROM loans WHERE id = ?";
        jdbcTemplate.update(sql, id);
        logger.info("Deleted loan with id: {}", id);
    }

    // Get all loans
    public List<Loan> getAllLoans() {
        String sql = "SELECT * FROM loans";
        List<Loan> loans=  jdbcTemplate.query(sql, loanRowMapper());
        logger.info("Retrieved all loans: {}", loans);
        return loans;
    }

    // RowMapper to map result set to Loan object
    private RowMapper<Loan> loanRowMapper() {
        return (rs, rowNum) -> new Loan(
                rs.getInt("id"),
                rs.getString("loan_type"),
                rs.getDouble("principal_amount"),
                rs.getDouble("interest_rate"),
                rs.getInt("loan_term")
        );
    }
}
