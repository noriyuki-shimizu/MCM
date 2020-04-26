package source.domain.presenter.shop;

import source.controller.shops.assist.response.ShopAssistResponseViewModels;
import source.domain.entity.db.Shops;

import java.util.List;

public interface IShopAssistsMappingPresenter {
    ShopAssistResponseViewModels mapping(List<Shops> shops);
}
