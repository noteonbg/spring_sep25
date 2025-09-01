package a03com.poc.controller;


import a03com.poc.entity.User;
import a03com.poc.entity.Investment;
import a03com.poc.service.InvestmentService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/api/investments")
public class InvestmentController {
    private final InvestmentService invService;

    public InvestmentController(InvestmentService invService) {
        this.invService = invService;
    }

    @SecurityRequirements
    @GetMapping
    public ResponseEntity<List<Investment>> getAll(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(invService.getInvestmentsByUser(user.getId()));
    }

    @SecurityRequirements
    @PostMapping
    public ResponseEntity<Investment> add(@AuthenticationPrincipal User user,
                                          @RequestBody Investment investment) {
        return ResponseEntity.ok(invService.addInvestment(user.getId(), investment));
    }
}

