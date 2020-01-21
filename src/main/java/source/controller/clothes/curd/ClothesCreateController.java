package source.controller.clothes.curd;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import source.controller.clothes.ClothesController;
import source.usecases.app.clothes.IClothesCreateUsecase;
import source.usecases.dto.request.clothes.ClothesCreateRequestModel;
import source.usecases.dto.response.clothes.ClothesResponseViewModel;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ClothesCreateController extends ClothesController {

    @Autowired
    private IClothesCreateUsecase usecase;

    @PostMapping("/")
    public ClothesResponseViewModel createHandler(@PathVariable("userId") Long userId, @RequestBody ClothesCreateRequestModel inputData) {
        return this.usecase.create(userId, inputData);
    }
}
