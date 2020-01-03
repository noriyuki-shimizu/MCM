package source.presenter.assist.interactor;

import org.springframework.stereotype.Component;
import source.usecases.dto.response.assist.ShopResponseData;
import source.domain.entity.Shops;
import source.presenter.assist.IAssistShopSearchPresenter;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AssistShopSearchPresenter implements IAssistShopSearchPresenter {

    @Override
    public List<ShopResponseData> handle(List<Shops> shopsList) {
        return shopsList.stream().map(shop -> ShopResponseData.of(shop.getId(), shop.getName()))
                                 .collect(Collectors.toList());
    }
}
