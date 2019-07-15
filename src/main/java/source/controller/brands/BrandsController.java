package source.controller.brands;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/{userId}/brands")
public class BrandsController {
    protected static final ObjectMapper MAPPER = new ObjectMapper();
}
