package source.usecases.app.shops;

import source.usecases.dto.response.shops.ShopResponseModel;

public interface ShopRestorationUsecase {
    public ShopResponseModel restoration(Long id);
}
