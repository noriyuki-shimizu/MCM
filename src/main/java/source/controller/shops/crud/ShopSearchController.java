package source.controller.shops.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import source.controller.shops.ShopsController;
import source.usecases.app.shops.IShopSearchUsecase;
import source.usecases.dto.response.shops.ShopResponseViewModels;

@RestController
@RequiredArgsConstructor
public class ShopSearchController extends ShopsController {

    @Autowired
    private IShopSearchUsecase usecase;

    @GetMapping()
    public ShopResponseViewModels handle(@PathVariable("userId") Long userId) {
        return ShopResponseViewModels.of(
                this.usecase.search(userId)
        );
    }

}
