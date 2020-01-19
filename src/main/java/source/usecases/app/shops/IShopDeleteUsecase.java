package source.usecases.app.shops;

import source.usecases.dto.response.shops.ShopResponseViewModel;

public interface IShopDeleteUsecase {
    public ShopResponseViewModel delete(Long id);
}
