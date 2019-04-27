package source.usecases.assist;

import source.domain.dto.assist.ShopOutputData;

import java.util.List;

public interface IAssistShopSearchUsecase {

    public List<ShopOutputData> getAssistShopList();

}
