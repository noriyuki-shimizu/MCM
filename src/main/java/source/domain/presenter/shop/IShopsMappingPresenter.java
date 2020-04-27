package source.domain.presenter.shop;

import source.controller.shops.crud.response.ShopResponseViewModels;
import source.domain.entity.db.Shops;

import java.util.List;

public interface IShopsMappingPresenter {
    ShopResponseViewModels mapping(final List<Shops> shops);
}
