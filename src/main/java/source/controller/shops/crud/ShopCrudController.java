package source.controller.shops.crud;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import source.controller.shops.ShopsController;
import source.usecases.IShopCrudUsecase;
import source.controller.shops.crud.request.ShopCreateRequestModel;
import source.controller.shops.crud.request.ShopUpdateRequestModel;
import source.controller.shops.crud.response.ShopResponseViewModel;
import source.controller.shops.crud.response.ShopResponseViewModels;

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
    public ShopResponseViewModels handleSearch(@PathVariable("userId") Long userId) {
        return usecase.search(userId);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ShopResponseViewModel handleSearchById(@PathVariable("id") Long id) {
        return usecase.searchById(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(
            @PathVariable("userId") Long userId,
            @PathVariable("id") Long id,
            @RequestBody ShopUpdateRequestModel requestData
    ) {
        usecase.update(userId, id, requestData);
    }
}
