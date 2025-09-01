package a01loanapp.service;




import a01loanapp.model.Loan;
import a01loanapp.repository.LoanRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LoanServiceTest {

    @Mock
    private LoanRepository loanRepository;

    @InjectMocks
    private LoanService loanService;

    private Loan sampleLoan;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        sampleLoan = new Loan("Personal Loan", 10000, 5.5, 12);
        sampleLoan.setId(1L);
    }

    @Test
    void testGetAllLoans() {
        List<Loan> loanList = Arrays.asList(sampleLoan);
        when(loanRepository.findAll()).thenReturn(loanList);

        List<Loan> result = loanService.getAllLoans();

        assertEquals(1, result.size());
        verify(loanRepository, times(1)).findAll();
    }

    @Test
    void testGetLoanById() {
        when(loanRepository.findById(1L)).thenReturn(Optional.of(sampleLoan));

        Optional<Loan> result = loanService.getLoanById(1L);

        assertTrue(result.isPresent());
        assertEquals(sampleLoan.getLoanType(), result.get().getLoanType());
    }

    @Test
    void testCreateLoan() {
        when(loanRepository.save(sampleLoan)).thenReturn(sampleLoan);

        Loan result = loanService.createLoan(sampleLoan);

        assertNotNull(result);
        assertEquals(sampleLoan.getLoanType(), result.getLoanType());
        verify(loanRepository).save(sampleLoan);
    }

    @Test
    void testUpdateLoan() {
        Loan updatedDetails = new Loan("Updated Loan", 20000, 6.0, 24);

        when(loanRepository.findById(1L)).thenReturn(Optional.of(sampleLoan));
        when(loanRepository.save(any(Loan.class))).thenReturn(sampleLoan);

        Loan updatedLoan = loanService.updateLoan(1L, updatedDetails);

        assertEquals("Updated Loan", updatedLoan.getLoanType());
        verify(loanRepository).save(any(Loan.class));
    }

    @Test
    void testDeleteLoan() {
        doNothing().when(loanRepository).deleteById(1L);

        loanService.deleteLoan(1L);

        verify(loanRepository).deleteById(1L);
    }
}
