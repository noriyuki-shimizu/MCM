package source.usecases.app.shops;

import source.usecases.dto.response.shops.ShopResponseViewModels;

public interface IShopSearchUsecase {
    public ShopResponseViewModels search(Long userId);
}
