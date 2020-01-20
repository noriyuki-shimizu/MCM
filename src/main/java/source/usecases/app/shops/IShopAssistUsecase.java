package source.usecases.app.shops;

import source.usecases.dto.response.shops.ShopAssistResponseViewModels;

public interface IShopAssistUsecase {
    public ShopAssistResponseViewModels assist(Long userId);
}
