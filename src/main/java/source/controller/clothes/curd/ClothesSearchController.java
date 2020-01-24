package source.controller.clothes.curd;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import source.controller.clothes.ClothesController;
import source.usecases.app.clothes.IClothesSearchUsecase;
import source.usecases.dto.response.clothes.ClothesResponseViewModels;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ClothesSearchController extends ClothesController {

    @Autowired
    private IClothesSearchUsecase usecase;

    @GetMapping()
    public ClothesResponseViewModels search(@PathVariable("userId") Long userId) {
        return this.usecase.search(userId);
    }

}
