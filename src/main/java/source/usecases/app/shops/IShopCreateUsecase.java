package source.usecases.app.shops;

import source.usecases.dto.request.shops.ShopCreateRequestData;
import source.usecases.dto.response.shops.ShopResponseViewModel;

public interface IShopCreateUsecase {
    public ShopResponseViewModel create(Long userId, ShopCreateRequestData inputData);
}
