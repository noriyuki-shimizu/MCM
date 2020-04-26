package source.presenter.shop;

import org.springframework.stereotype.Component;
import source.controller.shops.crud.response.ShopResponseModel;
import source.controller.shops.crud.response.ShopResponseViewModel;
import source.domain.entity.db.Images;
import source.domain.entity.db.Shops;
import source.domain.presenter.shop.IShopMappingPresenter;

import java.util.Optional;

@Component
public class ShopMappingPresenter implements IShopMappingPresenter {
    @Override
    public ShopResponseViewModel mapping(Shops shop) {
        ShopResponseModel model = ShopResponseModel.of(
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
}
