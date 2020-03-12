package source.presenter.shop;

import source.domain.entity.Shops;
import source.controller.shops.crud.response.ShopResponseViewModel;

public interface IShopMappingPresenter {
    ShopResponseViewModel mapping(Shops shop);
}
