package source.usecases.app.shops.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.domain.entity.Shops;
import source.domain.repository.db.ShopsRepository;
import source.domain.repository.db.specification.ShopsSpecification;
import source.presenter.shop.IShopAssistsMappingPresenter;
import source.usecases.app.shops.IShopAssistUsecase;
import source.usecases.dto.response.shops.ShopAssistResponseViewModels;

import java.util.List;

@Component
public class ShopAssistInteractor implements IShopAssistUsecase {
    @Autowired
    private ShopsRepository repository;

    @Autowired
    private IShopAssistsMappingPresenter presenter;

    @Override
    public ShopAssistResponseViewModels assist(Long userId) {
        List<Shops> shops = this.repository.findAll(
                Specifications
                        .where(ShopsSpecification.userIdEqual(userId))
                        .and(ShopsSpecification.isDeleted(false))
        );

        return this.presenter.mapping(shops);
    }
}
