package source.usecases.app.shops;

import source.usecases.dto.request.shops.ShopUpdateRequestData;
import source.usecases.dto.response.shops.ShopResponseModel;

public interface IShopUpdateUsecase {
    public ShopResponseModel update(Long userId, Long id, ShopUpdateRequestData inputData);
}
