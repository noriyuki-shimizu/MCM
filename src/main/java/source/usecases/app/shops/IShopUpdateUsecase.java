package source.usecases.app.shops;

import source.usecases.dto.input.shops.ShopUpdateInputData;
import source.domain.entity.Shops;

public interface IShopUpdateUsecase {
    public Shops update(Long userId, ShopUpdateInputData inputData);
}
