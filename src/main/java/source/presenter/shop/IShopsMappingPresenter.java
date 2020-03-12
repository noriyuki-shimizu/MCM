package source.presenter.shop;

import source.domain.entity.Shops;
import source.controller.shops.crud.response.ShopResponseViewModels;

import java.util.List;

public interface IShopsMappingPresenter {
    ShopResponseViewModels mapping(List<Shops> shops);
}
