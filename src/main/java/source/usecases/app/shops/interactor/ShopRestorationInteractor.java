package source.usecases.app.shops.interactor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.entity.Shops;
import source.domain.repository.db.ShopsRepository;
import source.presenter.shop.IShopMappingPresenter;
import source.usecases.app.shops.ShopRestorationUsecase;
import source.usecases.dto.response.shops.ShopResponseViewModel;

import javax.transaction.Transactional;

@Component
@Transactional
@Slf4j
public class ShopRestorationInteractor implements ShopRestorationUsecase {
    @Autowired
    private ShopsRepository repository;

    @Autowired
    private IShopMappingPresenter presenter;

    public ShopResponseViewModel restoration(Long id) {
        Shops result = this.repository.restorationById(id);
        return this.presenter.mapping(result);
    }
}
