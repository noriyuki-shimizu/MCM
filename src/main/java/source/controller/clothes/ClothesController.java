package source.controller.clothes;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/{userId}/clothes")
public class ClothesController {
    protected static final ObjectMapper MAPPER = new ObjectMapper();
}
