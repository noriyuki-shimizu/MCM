package source.usecases.app.shops;

import source.usecases.dto.request.shops.ShopCreateRequestData;
import source.usecases.dto.response.shops.ShopResponseModel;

public interface IShopCreateUsecase {
    public ShopResponseModel create(Long userId, ShopCreateRequestData inputData);
}
