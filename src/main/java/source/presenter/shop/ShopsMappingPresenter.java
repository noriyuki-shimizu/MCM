package source.presenter.shop;

import org.springframework.stereotype.Component;
import source.controller.shops.crud.response.ShopResponseModel;
import source.controller.shops.crud.response.ShopResponseViewModels;
import source.domain.entity.db.Images;
import source.domain.entity.db.Shops;
import source.domain.presenter.shop.IShopsMappingPresenter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ShopsMappingPresenter implements IShopsMappingPresenter {
    @Override
    public ShopResponseViewModels mapping(List<Shops> shops) {
        List<ShopResponseModel> models = shops
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
