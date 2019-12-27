package source.controller.images;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/images")
public class ImageController {
    protected static final ObjectMapper MAPPER = new ObjectMapper();
}
