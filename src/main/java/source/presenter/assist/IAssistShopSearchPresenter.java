package source.presenter.assist;

import source.usecases.dto.response.assist.ShopResponseData;
import source.domain.entity.Shops;

import java.util.List;

public interface IAssistShopSearchPresenter {
    public List<ShopResponseData> handle(List<Shops> shopList);
}
