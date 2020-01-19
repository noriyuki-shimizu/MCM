package source.presenter.shop;

import org.springframework.stereotype.Component;
import source.domain.entity.Shops;
import source.usecases.dto.response.shops.ShopResponseModel;
import source.usecases.dto.response.shops.ShopResponseViewModels;

import java.util.List;
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
                ))
                .collect(Collectors.toList());

        return ShopResponseViewModels.of(models);
    }
}
