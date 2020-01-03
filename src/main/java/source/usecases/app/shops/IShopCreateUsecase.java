package source.usecases.app.shops;

import source.usecases.dto.request.shops.ShopCreateRequestData;
import source.domain.entity.Shops;

public interface IShopCreateUsecase {
    public Shops create(Long userId, ShopCreateRequestData inputData);
}
