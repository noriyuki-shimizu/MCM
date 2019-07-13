package source.controller.brands;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import source.controller.assist.BrandController;

@RestController
@RequiredArgsConstructor
public class SearchController extends BrandController {

    @GetMapping(value = "/")
    public String searchHandler(@PathVariable("userId") Long userId) {
        return "";
    }
}
