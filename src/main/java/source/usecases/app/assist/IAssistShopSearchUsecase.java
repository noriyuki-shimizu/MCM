package source.usecases.app.assist;

import source.usecases.dto.output.assist.ShopOutputData;

import java.util.List;

public interface IAssistShopSearchUsecase {
    public List<ShopOutputData> getAssistShopList();
}
