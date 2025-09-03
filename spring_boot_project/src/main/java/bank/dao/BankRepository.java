package bank.dao;

import bank.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankRepository extends JpaRepository<Bank,Integer> {

    List<Bank> findByheadoffice(String headoffice);


}
