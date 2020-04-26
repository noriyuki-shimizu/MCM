package source.domain.presenter.shop;

import source.controller.shops.crud.response.ShopResponseViewModel;
import source.domain.entity.db.Shops;

public interface IShopMappingPresenter {
    ShopResponseViewModel mapping(Shops shop);
}
