package source.controller.shops.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import source.controller.shops.ShopsController;
import source.usecases.app.shops.IShopDeleteUsecase;
import source.usecases.dto.response.shops.ShopResponseViewModel;

@RestController
@RequiredArgsConstructor
public class ShopDeleteController extends ShopsController {

    @Autowired
    private IShopDeleteUsecase usecase;

    @DeleteMapping(value = "/{id}")
    public ShopResponseViewModel handle(@PathVariable("id") Long id) {
        return this.usecase.delete(id);
    }
}
