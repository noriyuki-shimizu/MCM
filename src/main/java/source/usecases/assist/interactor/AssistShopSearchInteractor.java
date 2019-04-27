package source.usecases.assist.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.dto.assist.ShopOutputData;
import source.domain.entity.list.MShopList;
import source.domain.repository.MShopRepository;
import source.usecases.assist.IAssistShopSearchUsecase;

import java.util.List;

@Component
public class AssistShopSearchInteractor implements IAssistShopSearchUsecase {

    @Autowired
    private MShopRepository repository;

    @Override
    public List<ShopOutputData> getAssistShopList() {
        MShopList mShopList = MShopList.of(this.repository.findAll());

        return mShopList.convertAssistShopOutputData();
    }

}
