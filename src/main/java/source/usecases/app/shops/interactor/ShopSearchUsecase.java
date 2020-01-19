package source.usecases.app.shops.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.domain.entity.Shops;
import source.domain.repository.db.ShopsRepository;
import source.domain.repository.db.specification.ShopsSpecification;
import source.presenter.shop.IShopsMappingPresenter;
import source.usecases.app.shops.IShopSearchUsecase;
import source.usecases.dto.response.shops.ShopResponseViewModels;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class ShopSearchUsecase implements IShopSearchUsecase {

    @Autowired
    private ShopsRepository repository;

    @Autowired
    private IShopsMappingPresenter presenter;

    @Override
    public ShopResponseViewModels search(Long userId) {
        List<Shops> shops = this.repository.findAll(
                Specifications
                        .where(ShopsSpecification.userIdEqual(userId))
        );
        return this.presenter.mapping(shops);
    }
}
