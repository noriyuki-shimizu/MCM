package source.controller.coordinates;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/{userId}/coordinates")
public class CoordinatesController {
    protected static final ObjectMapper MAPPER = new ObjectMapper();
}
