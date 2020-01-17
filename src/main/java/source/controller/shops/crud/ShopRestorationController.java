package source.controller.shops.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import source.controller.shops.ShopsController;
import source.usecases.app.shops.ShopRestorationUsecase;
import source.usecases.dto.response.shops.ShopResponseViewModel;

@RestController
@RequiredArgsConstructor
public class ShopRestorationController extends ShopsController {
    @Autowired
    private ShopRestorationUsecase usecase;

    @PutMapping(value = "/{id}/restoration")
    public ShopResponseViewModel handle(@PathVariable("id") Long id) {
        return ShopResponseViewModel.of(
                this.usecase.restoration(id)
        );
    }
}
