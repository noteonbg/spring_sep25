package a02basicpoc.controller;


import a02basicpoc.entity.Investment;
import a02basicpoc.entity.User;
import a02basicpoc.service.InvestmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/investments")
public class InvestmentController {
    private final InvestmentService invService;

    public InvestmentController(InvestmentService invService) {
        this.invService = invService;
    }

    @GetMapping
    public ResponseEntity<List<Investment>> getAll(@RequestParam Long userid) {
        return ResponseEntity.ok(invService.getInvestmentsByUser(userid));
    }

    @PostMapping
    public ResponseEntity<Investment> add(@RequestParam Long userid,
                                          @RequestBody Investment investment) {
        return ResponseEntity.ok(invService.addInvestment(userid, investment));
    }
}

