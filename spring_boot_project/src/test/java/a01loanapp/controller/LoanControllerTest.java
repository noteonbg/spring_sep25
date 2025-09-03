package a01loanapp.controller;



import a01loanapp.config.SecurityConfig;
import a01loanapp.model.Loan;
import a01loanapp.service.LoanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@Import(SecurityConfig.class)
class LoanControllerTest {

    @Mock
    private LoanService loanService;

    @InjectMocks
    private LoanController loanController;

    private Loan sampleLoan;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sampleLoan = new Loan("Car Loan", 15000, 7.2, 36);
        sampleLoan.setId(1L);
    }

    @Test
    void testGetAllLoans() {
        when(loanService.getAllLoans()).thenReturn(List.of(sampleLoan));

        List<Loan> result = loanController.horrible123();

        assertEquals(1, result.size());
        verify(loanService).getAllLoans();
    }

    @Test
    void testGetLoanById_Found() {
        when(loanService.getLoanById(1L)).thenReturn(Optional.of(sampleLoan));

        ResponseEntity<Loan> response = loanController.getLoanById(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Car Loan", response.getBody().getLoanType());
    }

    @Test
    void testGetLoanById_NotFound() {
        when(loanService.getLoanById(2L)).thenReturn(Optional.empty());

        ResponseEntity<Loan> response = loanController.getLoanById(2L);

        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    void testCreateLoan() {
        when(loanService.createLoan(any(Loan.class))).thenReturn(sampleLoan);

        Loan createdLoan = loanController.createLoan(sampleLoan);

        assertNotNull(createdLoan);
        assertEquals("Car Loan", createdLoan.getLoanType());
    }

    @Test
    void testUpdateLoan_Success() {
        when(loanService.updateLoan(eq(1L), any(Loan.class))).thenReturn(sampleLoan);

        ResponseEntity<Loan> response = loanController.updateLoan(1L, sampleLoan);

        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void testUpdateLoan_NotFound() {
        when(loanService.updateLoan(eq(2L), any(Loan.class)))
                .thenThrow(new RuntimeException("Loan not found with id 2"));

        ResponseEntity<Loan> response = loanController.updateLoan(2L, sampleLoan);

        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    void testDeleteLoan() {
        doNothing().when(loanService).deleteLoan(1L);

        ResponseEntity<Void> response = loanController.deleteLoan(1L);

        assertEquals(204, response.getStatusCodeValue());
    }
}

