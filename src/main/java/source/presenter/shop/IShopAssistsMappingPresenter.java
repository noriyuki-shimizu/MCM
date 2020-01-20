package source.presenter.shop;

import source.domain.entity.Shops;
import source.usecases.dto.response.shops.ShopAssistResponseViewModels;

import java.util.List;

public interface IShopAssistsMappingPresenter {
    public ShopAssistResponseViewModels mapping(List<Shops> shops);
}
