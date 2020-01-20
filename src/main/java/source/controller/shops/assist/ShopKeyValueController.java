package source.controller.shops.assist;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import source.controller.shops.ShopsController;
import source.usecases.app.shops.IShopAssistUsecase;
import source.usecases.dto.response.shops.ShopAssistResponseViewModels;

@RestController
@RequiredArgsConstructor
public class ShopKeyValueController extends ShopsController {
    @Autowired
    private IShopAssistUsecase usecase;

    @GetMapping(value = "/keyValues")
    public ShopAssistResponseViewModels handle(@PathVariable("userId") Long userId) {
        return this.usecase.assist(userId);
    }
}
