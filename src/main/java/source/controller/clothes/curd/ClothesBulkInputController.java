package source.controller.clothes.curd;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/clothesBulkInput")
public class ClothesBulkInputController {

    @RequestMapping(value = "/save")
    public void save() {
    }

}
