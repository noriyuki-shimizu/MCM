package source.controller.clothes;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clothesList")
public class ClothesListController {
    protected static final ObjectMapper MAPPER = new ObjectMapper();
}
