package source.controller.brands.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import source.controller.brands.BrandsController;
import source.usecases.dto.request.brands.BrandCreateRequestModel;
import source.usecases.app.brands.IBrandCreateUsecase;
import source.usecases.dto.response.brands.BrandResponseViewModel;

@RestController
@RequiredArgsConstructor
public class BrandsCreateController extends BrandsController {

    @Autowired
    private IBrandCreateUsecase usecase;

    @PostMapping()
    public BrandResponseViewModel handle(@PathVariable("userId") Long userId, @RequestBody BrandCreateRequestModel requestData) {
        return this.usecase.create(userId, requestData);
    }
}
