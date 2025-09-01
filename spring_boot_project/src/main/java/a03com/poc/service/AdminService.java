package a03com.poc.service;


import a03com.poc.entity.*;
import a03com.poc.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final UserRepository userRepo;

    public AdminService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public long countInvestmentsByUser(User user) {
        return user.getInvestments() != null ? user.getInvestments().size() : 0;
    }
}
