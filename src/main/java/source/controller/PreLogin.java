package source.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PreLogin {

    @PostMapping("/preLogin")
    public void exec(@RequestParam("token") String token) {
        System.out.println(token);
    }
}
