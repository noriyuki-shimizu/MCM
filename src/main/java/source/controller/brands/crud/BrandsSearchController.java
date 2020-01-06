package source.controller.brands.crud;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import source.controller.brands.BrandsController;
import source.usecases.app.brands.IBrandSearchUsecase;
import source.usecases.dto.response.brands.BrandResponseViewModel;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BrandsSearchController extends BrandsController {

    @Autowired
    private IBrandSearchUsecase usecase;

    @GetMapping()
    public BrandResponseViewModel searchHandler(
            @PathVariable("userId") Long userId
    ) {
        return BrandResponseViewModel.of(
                this.usecase.search(userId)
        );
    }
}
