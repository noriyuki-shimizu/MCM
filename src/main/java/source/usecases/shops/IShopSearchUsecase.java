package source.usecases.shops;

import source.domain.dto.input.shops.ShopSearchInputData;
import source.domain.entity.Shops;

import java.util.List;

public interface IShopSearchUsecase {
    public List<Shops> search(Long userId, ShopSearchInputData inputData);
}
