package source.usecases.app.shops;

import source.usecases.dto.request.shops.ShopUpdateRequestModel;
import source.usecases.dto.response.shops.ShopResponseViewModel;

public interface IShopUpdateUsecase {
    public ShopResponseViewModel update(Long userId, Long id, ShopUpdateRequestModel inputData);
}
