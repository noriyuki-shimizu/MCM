package source.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import source.annotation.NonAuth;

@RestController
public class HealthController {
    @GetMapping("/health")
    @NonAuth
    public String health() {
        return "OK";
    }
}
