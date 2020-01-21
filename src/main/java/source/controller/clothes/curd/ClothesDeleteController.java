package source.controller.clothes.curd;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import source.controller.clothes.ClothesController;
import source.usecases.app.clothes.IClothesDeleteUsecase;
import source.usecases.dto.response.clothes.ClothesResponseViewModel;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ClothesDeleteController extends ClothesController {
    @Autowired
    private IClothesDeleteUsecase usecase;

    @DeleteMapping(value = "/{id}")
    public ClothesResponseViewModel deleteHandler(@PathVariable("id") Long id) {
        return this.usecase.delete(id);
    }
}
