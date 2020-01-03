package source.usecases.app.shops.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.usecases.dto.request.shops.ShopSearchRequestData;
import source.domain.entity.Shops;
import source.domain.repository.db.ShopsRepository;
import source.domain.repository.db.specification.ShopsSpecification;
import source.usecases.app.shops.IShopSearchUsecase;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class ShopSearchUsecase implements IShopSearchUsecase {

    @Autowired
    private ShopsRepository repository;

    @Override
    public List<Shops> search(Long userId, ShopSearchRequestData inputData) {
        return this.repository.findAll(
                Specifications
                        .where(ShopsSpecification.userIdEqual(userId))
                        .and(ShopsSpecification.nameLike(inputData.getName()))
                        .and(ShopsSpecification.stationNameLike(inputData.getStationName()))
                        .and(ShopsSpecification.addressLike(inputData.getAddress()))
                        .and(ShopsSpecification.isDeletedEqual(inputData.getIsDeleted()))
        );
    }
}
