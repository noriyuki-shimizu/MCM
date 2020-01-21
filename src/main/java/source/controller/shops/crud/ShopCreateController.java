package source.controller.shops.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import source.controller.shops.ShopsController;
import source.usecases.dto.request.shops.ShopCreateRequestModel;
import source.usecases.app.shops.IShopCreateUsecase;
import source.usecases.dto.response.shops.ShopResponseViewModel;

@RestController
@RequiredArgsConstructor
public class ShopCreateController extends ShopsController {

    @Autowired
    private IShopCreateUsecase usecase;

    @PostMapping()
    public ShopResponseViewModel handle(@PathVariable("userId") Long userId, @RequestBody ShopCreateRequestModel requestData) {
        return this.usecase.create(userId, requestData);
    }
}
