package source.usecases.app.shops;

import source.usecases.dto.input.shops.ShopCreateInputData;
import source.domain.entity.Shops;

public interface IShopCreateUsecase {
    public Shops create(Long userId, ShopCreateInputData inputData);
}
