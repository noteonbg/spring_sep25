package a03com.poc.repository;

import a03com.poc.entity.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InvRepository extends JpaRepository<Investment, Long> {
    List<Investment> findByUserId(Long userId);
}

