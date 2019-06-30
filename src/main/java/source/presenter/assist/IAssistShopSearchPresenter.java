package source.presenter.assist;

import source.domain.dto.output.assist.ShopOutputData;
import source.domain.entity.Shops;

import java.util.List;

public interface IAssistShopSearchPresenter {
    public List<ShopOutputData> handle(List<Shops> shopList);
}
