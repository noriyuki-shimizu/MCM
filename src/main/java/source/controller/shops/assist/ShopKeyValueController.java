package source.controller.shops.assist;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import source.controller.shops.ShopsController;
import source.usecases.app.shops.IShopCrudUsecase;
import source.usecases.dto.response.shops.ShopAssistResponseViewModels;

@RestController
@RequiredArgsConstructor
public class ShopKeyValueController extends ShopsController {
    @Autowired
    private IShopCrudUsecase usecase;

    @GetMapping(value = "/keyValues")
    @ResponseStatus(HttpStatus.OK)
    public ShopAssistResponseViewModels handle(@PathVariable("userId") Long userId) {
        return this.usecase.acceptKeyValues(userId);
    }
}
