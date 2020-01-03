package source.usecases.app.assist;

import source.usecases.dto.response.assist.ShopResponseData;

import java.util.List;

public interface IAssistShopSearchUsecase {
    public List<ShopResponseData> getAssistShopList();
}
