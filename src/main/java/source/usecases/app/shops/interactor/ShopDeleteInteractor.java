package source.usecases.app.shops.interactor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.domain.entity.Clothes;
import source.domain.entity.Shops;
import source.domain.repository.db.ClothesRepository;
import source.domain.repository.db.ShopsRepository;
import source.domain.repository.db.specification.ClothesSpecification;
import source.presenter.shop.IShopMappingPresenter;
import source.usecases.app.shops.IShopDeleteUsecase;
import source.usecases.dto.response.shops.ShopResponseViewModel;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
@Slf4j
public class ShopDeleteInteractor implements IShopDeleteUsecase {

    @Autowired
    private ShopsRepository repository;

    @Autowired
    private ClothesRepository clothesRepository;

    @Autowired
    private IShopMappingPresenter presenter;

    @Override
    public ShopResponseViewModel delete(Long id) {
        List<Clothes> clothes = this.clothesRepository.findAll(
                Specifications
                        .where(ClothesSpecification.shopIdEqual(id))
        );
        if(clothes != null && clothes.size() > 0) {
            String errorMessage = "The shop cannot be deleted because it is used by other data.";
            log.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }

        Shops result = this.repository.deleteById(id);

        return this.presenter.mapping(result);
    }
}
