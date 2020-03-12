package source.presenter.shop;

import source.domain.entity.Shops;
import source.controller.shops.crud.response.ShopResponseViewModel;

public interface IShopMappingPresenter {
    public ShopResponseViewModel mapping(Shops shop);
}
