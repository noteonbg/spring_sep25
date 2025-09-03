package a10testing.service;



import a10testing.model.Patient;
import a10testing.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PatientServiceTest {

    @Test
    void testGetPatientById() {
        // Arrange
        PatientRepository mockRepo = mock(PatientRepository.class);
        PatientService service = new PatientService(mockRepo);
        Patient mockPatient = new Patient(1L, "Alice", 30);

        when(mockRepo.findById(1L)).thenReturn(Optional.of(mockPatient));

        // Act
        Optional<Patient> result = service.getPatientById(1L);

        // Assert
        assertTrue(result.isPresent());
        assertEquals("Alice", result.get().getName());
        verify(mockRepo, times(1)).findById(1L);
    }
}

