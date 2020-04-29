package source.domain.presenter;

import source.controller.shops.assist.response.ShopAssistResponseViewModels;
import source.controller.shops.crud.response.ShopResponseViewModel;
import source.controller.shops.crud.response.ShopResponseViewModels;
import source.domain.entity.db.Shops;

import java.util.List;

public interface IShopPresenter {
    ShopAssistResponseViewModels toShopAssistResponseViewModels(final List<Shops> shops);
    ShopResponseViewModel toShopResponseViewModel(final Shops shop);
    ShopResponseViewModels toShopResponseViewModels(final List<Shops> shops);
}
