package source.presenter.shop;

import org.springframework.stereotype.Component;
import source.domain.entity.Shops;
import source.usecases.dto.response.shops.ShopResponseModel;
import source.usecases.dto.response.shops.ShopResponseViewModel;

@Component
public class ShopMappingPresenter implements IShopMappingPresenter {
    @Override
    public ShopResponseViewModel mapping(Shops shop) {
        ShopResponseModel model = ShopResponseModel.of(
                shop.getId(),
                shop.getName(),
                shop.getLink(),
                shop.getStationName(),
                shop.getImage() != null
                        ? shop.getImage().getId()
                        : null,
                shop.getImage() != null
                        ? shop.getImage().getPath()
                        : null,
                shop.getAddress(),
                shop.getBusinessHours(),
                shop.getTel(),
                shop.isDeleted()
        );

        return ShopResponseViewModel.of(model);
    }
}
