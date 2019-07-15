package source.controller.shops;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/{userId}/shops")
public class ShopsController {
    protected static final ObjectMapper MAPPER = new ObjectMapper();
}
