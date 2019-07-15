package source.usecases.shops;

import source.domain.dto.input.shops.ShopUpdateInputData;
import source.domain.entity.Shops;

public interface IShopUpdateUsecase {
    public Shops update(Long userId, ShopUpdateInputData inputData);
}
