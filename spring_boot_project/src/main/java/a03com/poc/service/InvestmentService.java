package a03com.poc.service;



import a03com.poc.entity.Investment;
import a03com.poc.entity.User;
import a03com.poc.repository.InvRepository;
import a03com.poc.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestmentService {
    private final InvRepository invRepo;
    private final UserRepository userRepo;

    public InvestmentService(InvRepository invRepo, UserRepository userRepo) {
        this.invRepo = invRepo;
        this.userRepo = userRepo;
    }

    public List<Investment> getInvestmentsByUser(Long userId) {
        return invRepo.findByUserId(userId);
    }

    public Investment addInvestment(Long userId, Investment investment) {
        User user = userRepo.findById(userId).orElseThrow(
                () -> new RuntimeException("User not found")
        );
        investment.setUser(user);
        return invRepo.save(investment);
    }

    // Optionally: update, delete, summary methods
}
