package source.controller.shops.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import source.controller.shops.ShopsController;
import source.usecases.dto.request.shops.ShopUpdateRequestData;
import source.usecases.app.shops.IShopUpdateUsecase;
import source.usecases.dto.response.shops.ShopResponseViewModel;

@RestController
@RequiredArgsConstructor
public class ShopUpdateController extends ShopsController {

    @Autowired
    private IShopUpdateUsecase usecase;

    @PutMapping(value = "/{id}")
    public ShopResponseViewModel handle(
            @PathVariable("userId") Long userId,
            @PathVariable("id") Long id,
            @RequestBody ShopUpdateRequestData requestData
    ) {
        return ShopResponseViewModel.of(
                this.usecase.update(userId, id, requestData)
        );
    }
}
