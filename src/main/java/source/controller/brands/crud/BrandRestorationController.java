package source.controller.brands.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import source.controller.brands.BrandsController;
import source.usecases.app.brands.IBrandRestorationUsecase;
import source.usecases.dto.response.brands.BrandResponseViewModel;

@RestController
@RequiredArgsConstructor
public class BrandRestorationController extends BrandsController {
    @Autowired
    private IBrandRestorationUsecase usecase;

    @PutMapping(value = "/{id}/restoration")
    public BrandResponseViewModel handle(@PathVariable("id") Long id) {
        return BrandResponseViewModel.of(this.usecase.restoration(id));
    }
}
