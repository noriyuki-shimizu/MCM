package source.presenter.shop;

import source.domain.entity.Shops;
import source.usecases.dto.response.shops.ShopResponseViewModel;

public interface IShopMappingPresenter {
    public ShopResponseViewModel mapping(Shops shop);
}
