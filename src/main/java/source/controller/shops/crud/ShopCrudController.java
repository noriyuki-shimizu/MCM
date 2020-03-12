package source.controller.shops.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import source.controller.shops.ShopsController;
import source.usecases.app.shops.IShopCrudUsecase;
import source.usecases.dto.request.shops.ShopCreateRequestModel;
import source.usecases.dto.request.shops.ShopUpdateRequestModel;
import source.usecases.dto.response.shops.ShopResponseViewModel;
import source.usecases.dto.response.shops.ShopResponseViewModels;

@RestController
@RequiredArgsConstructor
public class ShopCrudController extends ShopsController {
    @Autowired
    private IShopCrudUsecase usecase;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ShopResponseViewModel handleCreate(
            @PathVariable("userId") Long userId,
            @RequestBody ShopCreateRequestModel requestData
    ) {
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
    public ShopResponseViewModels handleSearch(@PathVariable("userId") Long userId) {
        return this.usecase.search(userId);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ShopResponseViewModel handleSearchById(@PathVariable("id") Long id) {
        return this.usecase.searchById(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(
            @PathVariable("userId") Long userId,
            @PathVariable("id") Long id,
            @RequestBody ShopUpdateRequestModel requestData
    ) {
        this.usecase.update(userId, id, requestData);
    }
}
