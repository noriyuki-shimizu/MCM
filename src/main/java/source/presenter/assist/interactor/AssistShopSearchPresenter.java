package source.presenter.assist.interactor;

import org.springframework.stereotype.Component;
import source.domain.dto.assist.ShopOutputData;
import source.domain.entity.MShop;
import source.presenter.assist.IAssistShopSearchPresenter;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AssistShopSearchPresenter implements IAssistShopSearchPresenter {

    @Override
    public List<ShopOutputData> handle(List<MShop> mShopList) {
        return mShopList.stream().map(shop -> ShopOutputData.of(shop.getId(), shop.getName()))
                                 .collect(Collectors.toList());
    }
}
