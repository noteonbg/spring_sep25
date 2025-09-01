package a02basicpoc.repository;

import a02basicpoc.entity.Investment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvRepository extends JpaRepository<Investment, Long> {
    List<Investment> findByUserId(Long userId);
}

