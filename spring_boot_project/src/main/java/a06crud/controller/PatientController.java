package a06crud.controller;



import a06crud.model.Patient;
import a06crud.repository.PatientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/patients")
public class PatientController {


    private final PatientRepository repository;

    public PatientController(PatientRepository repository)
    {
        this.repository = repository;
    }

   @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        try {

            if (patient.getId() != null && repository.existsById(patient.getId())) {
                return new ResponseEntity<>(patient, HttpStatus.BAD_REQUEST);
             }
            Patient savedPatient = repository.save(patient);
            return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = repository.findAll();
        if (patients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Optional<Patient> box = repository.findById(id);
        if(box.isPresent())
        {
            Patient gotpatient =  box.get();
            return new ResponseEntity<>(gotpatient, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

        /*return box.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  */  }


    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient updatedPatient) {

            if(repository.existsById(updatedPatient.getId()))
            {
                repository.save(updatedPatient);
                return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
            }
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);




//        Optional<Patient> optionalPatient = repository.findById(id);
//
//        if (optionalPatient.isPresent()) {
//
//            /*
//            Patient existingPatient = optionalPatient.get();
//            existingPatient.setName(updatedPatient.getName());
//            existingPatient.setAge(updatedPatient.getAge());
//            existingPatient.setGender(updatedPatient.getGender());
//            existingPatient.setCondition(updatedPatient.getCondition());
//
//            repository.save(existingPatient);
//            return new ResponseEntity<>(existingPatient, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePatient(@PathVariable Long id) {
        try {
            if (repository.existsById(id)) {
                repository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllPatients() {
        try {
            repository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
