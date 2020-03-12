package source.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import source.annotation.NonAuth;

@RestController
public class HealthController {
    @GetMapping("/health")
    @NonAuth
    @ResponseStatus(HttpStatus.OK)
    public String health() {
        return "OK";
    }
}
