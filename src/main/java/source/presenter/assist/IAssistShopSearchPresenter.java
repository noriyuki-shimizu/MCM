package source.presenter.assist;

import source.domain.dto.assist.ShopOutputData;
import source.domain.entity.MShop;

import java.util.List;

public interface IAssistShopSearchPresenter {
    public List<ShopOutputData> handle(List<MShop> shopList);
}
