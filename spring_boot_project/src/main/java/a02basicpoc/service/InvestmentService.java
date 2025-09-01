package a02basicpoc.service;



import a02basicpoc.entity.Investment;
import a02basicpoc.entity.User;
import a02basicpoc.repository.InvRepository;
import a02basicpoc.repository.UserRepository;
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

    //bug in the code find out why..
    public Investment addInvestment(Long userId, Investment investment) {
        User user = userRepo.findById(userId).orElseThrow(
                () -> new RuntimeException("User not found")
        );
        investment.setUser(user);
        return invRepo.save(investment);
    }

    // Optionally: update, delete, summary methods
}
