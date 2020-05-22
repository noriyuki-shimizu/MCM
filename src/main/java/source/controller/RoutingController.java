package source.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import source.domain.logging.LoggingHead;

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
        log.info("{} userId = {}, resource = '{}'", LoggingHead.ROUTING.getKey(), userId, resource);
    }
}
