package a04onetoone_mapping.repository;



import a04onetoone_mapping.model.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenRepository extends JpaRepository<Citizen, Long> {
}

