package source.controller.brands.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import source.controller.brands.BrandsController;
import source.usecases.dto.request.brands.BrandUpdateRequestModel;
import source.usecases.app.brands.IBrandUpdateUsecase;
import source.usecases.dto.response.brands.BrandResponseViewModel;

@RestController
@RequiredArgsConstructor
public class BrandUpdateController extends BrandsController {

    @Autowired
    private IBrandUpdateUsecase usecase;

    @PutMapping(value = "/{id}")
    public BrandResponseViewModel handle(
            @PathVariable("userId") Long userId,
            @PathVariable("id") Long id,
            @RequestBody BrandUpdateRequestModel requestData
    ) {
        return this.usecase.update(userId, id, requestData);
    }
}
