package source.controller.brands.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import source.controller.brands.BrandsController;
import source.usecases.app.brands.IBrandCrudUsecase;
import source.usecases.dto.request.brands.BrandCreateRequestModel;
import source.usecases.dto.request.brands.BrandUpdateRequestModel;
import source.usecases.dto.response.brands.BrandResponseViewModel;
import source.usecases.dto.response.brands.BrandResponseViewModels;

@RestController
@RequiredArgsConstructor
public class BrandCrudController extends BrandsController {
    @Autowired
    private IBrandCrudUsecase usecase;

    @PostMapping()
    public BrandResponseViewModel handleCreate(@PathVariable("userId") Long userId, @RequestBody BrandCreateRequestModel requestData) {
        return this.usecase.create(userId, requestData);
    }

    @DeleteMapping(value = "/{id}")
    public BrandResponseViewModel handleDelete(@PathVariable("id") Long id) {
        return this.usecase.delete(id);
    }

    @PutMapping(value = "/{id}/restoration")
    public BrandResponseViewModel handleRestoration(@PathVariable("id") Long id) {
        return this.usecase.restoration(id);
    }

    @GetMapping()
    public BrandResponseViewModels handleSearch(@PathVariable("userId") Long userId) {
        return this.usecase.search(userId);
    }

    @GetMapping(value = "/{id}")
    public BrandResponseViewModel handleSearchById(@PathVariable("id") Long id) {
        return this.usecase.searchById(id);
    }

    @PutMapping(value = "/{id}")
    public BrandResponseViewModel handleUpdate(
            @PathVariable("userId") Long userId,
            @PathVariable("id") Long id,
            @RequestBody BrandUpdateRequestModel requestData
    ) {
        return this.usecase.update(userId, id, requestData);
    }
}
