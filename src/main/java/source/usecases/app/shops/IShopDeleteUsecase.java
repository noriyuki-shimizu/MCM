package source.usecases.app.shops;

import source.usecases.dto.response.shops.ShopResponseModel;

public interface IShopDeleteUsecase {
    public ShopResponseModel delete(Long id);
}
