package source.usecases.app.shops;

import source.usecases.dto.response.shops.ShopResponseModel;

import java.util.List;

public interface IShopSearchUsecase {
    public List<ShopResponseModel> search(Long userId);
}
