package a04onetoone_mapping.controller;

import a04onetoone_mapping.model.Citizen;
import a04onetoone_mapping.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*

GET http://localhost:8080/citizens → all citizens with Aadhaar info

GET http://localhost:8080/citizens/1 → individual citizen with Aadhaar

 */
@RestController
@RequestMapping("/citizens")
public class CitizenController {

    @Autowired
    private CitizenRepository citizenRepo;

    @GetMapping
    public List<Citizen> getAllCitizens() {
        return citizenRepo.findAll();
    }

    @GetMapping("/{id}")
    public Citizen getById(@PathVariable Long id) {
        return citizenRepo.findById(id).orElse(null);
    }
}
