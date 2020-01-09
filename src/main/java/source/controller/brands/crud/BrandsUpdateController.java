package source.controller.brands.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import source.controller.brands.BrandsController;
import source.usecases.dto.request.brands.BrandUpdateRequestData;
import source.usecases.app.brands.IBrandUpdateUsecase;
import source.usecases.dto.response.brands.BrandResponseModel;
import source.usecases.dto.response.brands.BrandResponseViewModel;

@RestController
@RequiredArgsConstructor
public class BrandsUpdateController extends BrandsController {

    @Autowired
    private IBrandUpdateUsecase usecase;

    @PutMapping(value = "/{id}")
    public BrandResponseViewModel updateHandler(
            @PathVariable("userId") Long userId,
            @PathVariable("id") Long id,
            @RequestBody BrandUpdateRequestData requestData
    ) {
        BrandResponseModel model = this.usecase.update(userId, id, requestData);
        return BrandResponseViewModel.of(model);
    }
}
