package source.controller.brands.crud;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import source.controller.brands.BrandsController;
import source.controller.brands.crud.request.BrandCreateRequestModel;
import source.controller.brands.crud.request.BrandUpdateRequestModel;
import source.controller.brands.crud.response.BrandResponseViewModel;
import source.controller.brands.crud.response.BrandResponseViewModels;
import source.usecases.IBrandCrudUsecase;

@Slf4j(topic = "source.controller.brands.crud")
@RestController
@RequiredArgsConstructor
public class BrandCrudController extends BrandsController {
    @Autowired
    private IBrandCrudUsecase usecase;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public BrandResponseViewModel handleCreate(@PathVariable("userId") Long userId, @RequestBody BrandCreateRequestModel requestData) {
        return usecase.create(userId, requestData);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable("userId") Long userId, @PathVariable("id") Long id) {
        usecase.delete(userId, id);
    }

    @PutMapping(value = "/{id}/restoration")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleRestoration(@PathVariable("userId") Long userId, @PathVariable("id") Long id) {
        usecase.restoration(userId, id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public BrandResponseViewModels handleSearch(@PathVariable("userId") Long userId) {
        return usecase.search(userId);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BrandResponseViewModel handleSearchById(@PathVariable("id") Long id) {
        return usecase.searchById(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(
            @PathVariable("userId") Long userId,
            @PathVariable("id") Long id,
            @RequestBody BrandUpdateRequestModel requestData
    ) {
        usecase.update(userId, id, requestData);
    }
}
