package source.presenter.shop;

import source.domain.entity.Shops;
import source.controller.shops.assist.response.ShopAssistResponseViewModels;

import java.util.List;

public interface IShopAssistsMappingPresenter {
    public ShopAssistResponseViewModels mapping(List<Shops> shops);
}
