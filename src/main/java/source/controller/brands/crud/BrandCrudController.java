package source.controller.brands.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public BrandResponseViewModel handleCreate(@PathVariable("userId") Long userId, @RequestBody BrandCreateRequestModel requestData) {
        return this.usecase.create(userId, requestData);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable("id") Long id) {
        this.usecase.delete(id);
    }

    @PutMapping(value = "/{id}/restoration")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleRestoration(@PathVariable("id") Long id) {
        this.usecase.restoration(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public BrandResponseViewModels handleSearch(@PathVariable("userId") Long userId) {
        return this.usecase.search(userId);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BrandResponseViewModel handleSearchById(@PathVariable("id") Long id) {
        return this.usecase.searchById(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(
            @PathVariable("userId") Long userId,
            @PathVariable("id") Long id,
            @RequestBody BrandUpdateRequestModel requestData
    ) {
        this.usecase.update(userId, id, requestData);
    }
}
