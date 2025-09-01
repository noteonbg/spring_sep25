package a10jwt.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "bearerAuth")
public class CalculatorController {

    @GetMapping("/add")
    public ResponseEntity<?> add(@RequestParam int a, @RequestParam int b) {
        return ResponseEntity.ok("Result: " + (a + b));
    }

    @GetMapping("/multiply")
    public ResponseEntity<?> multiply(@RequestParam int a, @RequestParam int b) {
        return ResponseEntity.ok("Result: " + (a * b));
    }

    @GetMapping("/divide")
    public ResponseEntity<?> divide(@RequestParam int a, @RequestParam int b) {
        if (b == 0) return ResponseEntity.badRequest().body("Cannot divide by zero");
        return ResponseEntity.ok("Result: " + (a / b));
    }
}

