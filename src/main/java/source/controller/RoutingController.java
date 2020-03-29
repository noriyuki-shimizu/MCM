package source.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "/{userId}/routing")
public class RoutingController {
    @PostMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void routing(
            @PathVariable("userId") Long userId,
            @RequestBody String resource
    ) {
        log.info(String.format("userId: %4d, resource: %s", userId, resource));
    }
}
