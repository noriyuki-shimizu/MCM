package source.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import source.annotation.NonAuth;

@RestController
@RequestMapping(value = "/health")
public class HealthController {
    @GetMapping()
    @NonAuth
    @ResponseStatus(HttpStatus.OK)
    public String health() {
        return "OK";
    }
}
