package a10testing.repository;

import a10testing.model.Patient;
import java.util.Optional;

public interface PatientRepository {
    Optional<Patient> findById(Long id);
}
