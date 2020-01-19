package source.controller.brands.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import source.controller.brands.BrandsController;
import source.usecases.app.brands.IBrandDeleteUsecase;
import source.usecases.dto.response.brands.BrandResponseViewModel;

@RestController
@RequiredArgsConstructor
public class BrandsDeleteController extends BrandsController {

    @Autowired
    private IBrandDeleteUsecase usecase;

    @DeleteMapping(value = "/{id}")
    public BrandResponseViewModel handle(@PathVariable("id") Long id) {
        return this.usecase.delete(id);
    }
}
