package source.controller.genres;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/{userId}/genres")
public class GenresController {
    protected static final ObjectMapper MAPPER = new ObjectMapper();
}
