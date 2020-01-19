package source.presenter.shop;

import source.domain.entity.Shops;
import source.usecases.dto.response.shops.ShopResponseViewModels;

import java.util.List;

public interface IShopsMappingPresenter {
    public ShopResponseViewModels mapping(List<Shops> shops);
}
