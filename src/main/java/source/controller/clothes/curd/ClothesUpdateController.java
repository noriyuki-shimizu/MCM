package source.controller.clothes.curd;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import source.controller.clothes.ClothesController;
import source.usecases.app.clothes.IClothesUpdateUsecase;
import source.usecases.dto.request.clothes.ClothesUpdateRequestModel;
import source.usecases.dto.response.clothes.ClothesResponseViewModel;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ClothesUpdateController extends ClothesController {

    @Autowired
    private IClothesUpdateUsecase usecase;

    @PutMapping("/{id}")
    public ClothesResponseViewModel updateHandler(
            @PathVariable("userId") Long userId,
            @PathVariable("id") Long id,
            @RequestBody ClothesUpdateRequestModel inputData
    ) {
        return this.usecase.update(userId, id, inputData);
    }
}
