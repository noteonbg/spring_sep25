package a10testing.service;



import a10testing.model.Patient;
import a10testing.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


//PatientService is mine
//PatientRepository is not mine... ramesh code.

@Service
public class PatientService {
    private final PatientRepository repository;

    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    public Optional<Patient> getPatientById(Long id) {
        return repository.findById(id);
    }
}

