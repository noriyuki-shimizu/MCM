package source.usecases.app.shops;

import source.usecases.dto.request.shops.ShopUpdateRequestData;
import source.domain.entity.Shops;

public interface IShopUpdateUsecase {
    public Shops update(Long userId, ShopUpdateRequestData inputData);
}
