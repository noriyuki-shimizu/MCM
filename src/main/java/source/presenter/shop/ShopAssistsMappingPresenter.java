package source.presenter.shop;

import org.springframework.stereotype.Component;
import source.controller.shops.assist.response.ShopAssistResponseModel;
import source.controller.shops.assist.response.ShopAssistResponseViewModels;
import source.domain.entity.db.Shops;
import source.domain.presenter.shop.IShopAssistsMappingPresenter;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShopAssistsMappingPresenter implements IShopAssistsMappingPresenter {
    @Override
    public ShopAssistResponseViewModels mapping(final List<Shops> shops) {
        final List<ShopAssistResponseModel> models = shops
                .stream()
                .map(shop -> ShopAssistResponseModel.of(shop.getId(), shop.getName()))
                .collect(Collectors.toList());

        return ShopAssistResponseViewModels.of(models);
    }
}
