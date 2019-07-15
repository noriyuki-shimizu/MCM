package source.usecases.shops;

import source.domain.dto.input.shops.ShopCreateInputData;
import source.domain.entity.Shops;

public interface IShopCreateUsecase {
    public Shops create(Long userId, ShopCreateInputData inputData);
}
