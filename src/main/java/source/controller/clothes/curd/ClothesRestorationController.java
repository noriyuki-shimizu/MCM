package source.controller.clothes.curd;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import source.controller.clothes.ClothesController;
import source.usecases.app.clothes.IClothesRestorationUsecase;
import source.usecases.dto.response.clothes.ClothesResponseViewModel;

@RestController
@RequiredArgsConstructor
public class ClothesRestorationController extends ClothesController {
    @Autowired
    private IClothesRestorationUsecase usecase;

    @PutMapping(value = "/{id}/restoration")
    public ClothesResponseViewModel handle(@PathVariable("id") Long id) {
        return this.usecase.restoration(id);
    }
}
