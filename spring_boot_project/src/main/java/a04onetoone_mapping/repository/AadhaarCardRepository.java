package a04onetoone_mapping.repository;

import a04onetoone_mapping.model.AadhaarCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AadhaarCardRepository extends
        JpaRepository<AadhaarCard, Long> {
}
