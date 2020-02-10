package source.controller.shops.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ShopResponseViewModel createHandle(
            @PathVariable("userId") Long userId,
            @RequestBody ShopCreateRequestModel requestData
    ) {
        return this.usecase.create(userId, requestData);
    }

    @DeleteMapping(value = "/{id}")
    public ShopResponseViewModel deleteHandle(@PathVariable("id") Long id) {
        return this.usecase.delete(id);
    }

    @PutMapping(value = "/{id}/restoration")
    public ShopResponseViewModel restorationHandle(@PathVariable("id") Long id) {
        return this.usecase.restoration(id);
    }

    @GetMapping()
    public ShopResponseViewModels searchHandle(@PathVariable("userId") Long userId) {
        return this.usecase.search(userId);
    }

    @PutMapping(value = "/{id}")
    public ShopResponseViewModel updateHandle(
            @PathVariable("userId") Long userId,
            @PathVariable("id") Long id,
            @RequestBody ShopUpdateRequestModel requestData
    ) {
        return this.usecase.update(userId, id, requestData);
    }
}
