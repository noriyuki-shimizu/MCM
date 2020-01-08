package source.controller.brands.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import source.controller.brands.BrandsController;
import source.usecases.app.brands.IBrandSearchUsecase;
import source.usecases.dto.response.brands.BrandResponseViewModels;

@RestController
@RequiredArgsConstructor
public class BrandsSearchController extends BrandsController {

    @Autowired
    private IBrandSearchUsecase usecase;

    @GetMapping()
    public BrandResponseViewModels searchHandler(
            @PathVariable("userId") Long userId
    ) {
        return BrandResponseViewModels.of(
                this.usecase.search(userId)
        );
    }
}
