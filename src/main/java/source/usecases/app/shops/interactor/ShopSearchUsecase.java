package source.usecases.app.shops.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.domain.entity.Shops;
import source.domain.repository.db.ShopsRepository;
import source.domain.repository.db.specification.ShopsSpecification;
import source.usecases.app.shops.IShopSearchUsecase;
import source.usecases.dto.response.shops.ShopResponseModel;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class ShopSearchUsecase implements IShopSearchUsecase {

    @Autowired
    private ShopsRepository repository;

    @Override
    public List<ShopResponseModel> search(Long userId) {
        List<Shops> shops = this.repository.findAll(
                Specifications
                        .where(ShopsSpecification.userIdEqual(userId))
        );
        return shops.stream()
                .map(shop -> ShopResponseModel.of(
                    shop.getId(),
                    shop.getName(),
                    shop.getLink(),
                    shop.getStationName(),
                    shop.getImage() != null
                            ? shop.getImage().getId()
                            : null,
                    shop.getImage() != null
                            ? shop.getImage().getPath()
                            : null,
                    shop.getAddress(),
                    shop.getBusinessHours(),
                    shop.getTel(),
                    shop.isDeleted()
                ))
                .collect(Collectors.toList());
    }
}
