package source.presenter;

import org.springframework.stereotype.Component;
import source.controller.shops.assist.response.ShopAssistResponseModel;
import source.controller.shops.assist.response.ShopAssistResponseViewModels;
import source.controller.shops.crud.response.ShopResponseModel;
import source.controller.shops.crud.response.ShopResponseViewModel;
import source.controller.shops.crud.response.ShopResponseViewModels;
import source.domain.entity.db.Images;
import source.domain.entity.db.Shops;
import source.domain.presenter.IShopPresenter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ShopPresenter implements IShopPresenter {
    @Override
    public ShopAssistResponseViewModels toShopAssistResponseViewModels(List<Shops> shops) {
        final List<ShopAssistResponseModel> models = shops
                .stream()
                .map(shop -> ShopAssistResponseModel.of(shop.getId(), shop.getName()))
                .collect(Collectors.toList());

        return ShopAssistResponseViewModels.of(models);
    }

    @Override
    public ShopResponseViewModel toShopResponseViewModel(Shops shop) {
        final ShopResponseModel model = ShopResponseModel.of(
                shop.getId(),
                shop.getName(),
                shop.getLink(),
                shop.getStationName(),
                Optional.ofNullable(shop.getImage())
                        .map(Images::getId)
                        .orElse(null),
                Optional.ofNullable(shop.getImage())
                        .map(Images::getPath)
                        .orElse(null),
                shop.getAddress(),
                shop.getBusinessHours(),
                shop.getTel(),
                shop.isDeleted()
        );

        return ShopResponseViewModel.of(model);
    }

    @Override
    public ShopResponseViewModels toShopResponseViewModels(List<Shops> shops) {
        final List<ShopResponseModel> models = shops
                .stream()
                .map(shop -> ShopResponseModel.of(
                        shop.getId(),
                        shop.getName(),
                        shop.getLink(),
                        shop.getStationName(),
                        Optional.ofNullable(shop.getImage())
                                .map(Images::getId)
                                .orElse(null),
                        Optional.ofNullable(shop.getImage())
                                .map(Images::getPath)
                                .orElse(null),
                        shop.getAddress(),
                        shop.getBusinessHours(),
                        shop.getTel(),
                        shop.isDeleted()
                ))
                .collect(Collectors.toList());

        return ShopResponseViewModels.of(models);
    }
}
