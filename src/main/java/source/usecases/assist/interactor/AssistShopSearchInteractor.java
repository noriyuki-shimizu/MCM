package source.usecases.assist.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.dto.assist.ShopOutputData;
import source.domain.entity.MShop;
import source.domain.repository.MShopRepository;
import source.presenter.assist.IAssistShopSearchPresenter;
import source.usecases.assist.IAssistShopSearchUsecase;

import java.util.List;

@Component
public class AssistShopSearchInteractor implements IAssistShopSearchUsecase {

    @Autowired
    private MShopRepository repository;

    @Autowired
    private IAssistShopSearchPresenter presenter;

    @Override
    public List<ShopOutputData> getAssistShopList() {
        List<MShop> mShopList = this.repository.findAll();

        return presenter.handle(mShopList);
    }

}
