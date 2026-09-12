package br.edu.exemplo.primeiroprojeto;
 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class OlaController {
 
    @GetMapping("/ola")
    public String ola() {
        return "Olá, Spring Boot!";
    }
}
