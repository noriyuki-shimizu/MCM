package source.usecases.app.shops;

import source.usecases.dto.response.shops.ShopResponseViewModel;

public interface ShopRestorationUsecase {
    public ShopResponseViewModel restoration(Long id);
}
