package a07security.controller;



import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.web.bind.annotation.*;

@SecurityRequirement(name = "basicAuth")
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class CalculatorController {


    @GetMapping("/add")
    public int add(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }

    @GetMapping("/multiply")
    public int multiply(@RequestParam int a, @RequestParam int b) {
        return a * b;
    }
}

