package source.usecases.app.shops;

import source.usecases.dto.request.shops.ShopUpdateRequestData;
import source.usecases.dto.response.shops.ShopResponseViewModel;

public interface IShopUpdateUsecase {
    public ShopResponseViewModel update(Long userId, Long id, ShopUpdateRequestData inputData);
}
