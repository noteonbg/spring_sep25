package a08secfromdb.controller;



import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@SecurityRequirement(name = "basicAuth")
@RestController
public class TestController {

    @GetMapping("/f1")
    public String f1() {
        return "This is a SECURED endpoint (f1). You are authenticated.";
    }

    @GetMapping("/f2")
    public String f2() {
        return "This is an OPEN endpoint (f2). No authentication required.";
    }
}
