package a05onetomany.service;



import a05onetomany.model.Medicine;
import a05onetomany.model.Pharmacy;
import a05onetomany.repository.PharmacyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmaService {

    @Autowired
    private PharmacyRepository pharmacyRepository;

    @Transactional
    public Pharmacy savePharmacyWithMedicines(Pharmacy pharmacy, List<Medicine> medicines) {
        for (Medicine medicine : medicines) {
            medicine.setPharmacy(pharmacy); // set FK relationship
        }
        pharmacy.setMedicines(medicines);

        // Simulate an error: price can't be negative
        for (Medicine m : medicines) {
            if (m.getPrice() < 0) {
                throw new RuntimeException("Medicine price cannot be negative!");
            }
        }



        return pharmacyRepository.save(pharmacy);
    }

    /*

It wraps the savePharmacyWithMedicines() method in a transaction.
If any exception is thrown, everything is rolled back — no data is saved.

     */
}
