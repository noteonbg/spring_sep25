package a05onetomany.controller;


import a05onetomany.model.Medicine;
import a05onetomany.model.Pharmacy;
import a05onetomany.repository.PharmacyRepository;
import a05onetomany.service.PharmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
GET /pharmacies/1



 */

@RestController
@RequestMapping("/pharmacies")
public class PharmacyController {

    @Autowired
    private PharmacyRepository pharmacyRepo;


    @Autowired
    private PharmaService pharmaService;

    @PostMapping("/save")
    public Pharmacy createPharmacyWithMedicines(@RequestBody Pharmacy pharmacy) {
        List<Medicine> medicines = pharmacy.getMedicines();
        return pharmaService.savePharmacyWithMedicines(pharmacy, medicines);
    }

    /*

    {
  "name": "Netmeds",
  "location": "Pune",
  "medicines": [
    {
      "name": "Ibuprofen",
      "price": 25.5
    },
    {
      "name": "Aspirin",
      "price": -10  // 👈 This will trigger rollback
    }
  ]
}

     */

    @GetMapping
    public List<Pharmacy> getAllPharmacies() {
        return pharmacyRepo.findAll();
    }

    @GetMapping("/{id}")
    public Pharmacy getPharmacy(@PathVariable Long id) {
        return pharmacyRepo.findById(id).orElse(null);
    }

    @PostMapping
    public Pharmacy addPharmacy(@RequestBody Pharmacy pharmacy) {
        return pharmacyRepo.save(pharmacy);
    }
}

