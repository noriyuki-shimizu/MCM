package source.usecases.app.shops.interactor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.entity.Shops;
import source.domain.repository.db.ShopsRepository;
import source.usecases.app.shops.ShopRestorationUsecase;
import source.usecases.dto.response.shops.ShopResponseModel;

import javax.transaction.Transactional;

@Component
@Transactional
@Slf4j
public class ShopRestorationInteractor implements ShopRestorationUsecase {
    @Autowired
    private ShopsRepository repository;

    public ShopResponseModel restoration(Long id) {
        Shops result = this.repository.restorationById(id);
        return ShopResponseModel.of(
                result.getId(),
                result.getName(),
                result.getLink(),
                result.getStationName(),
                result.getImage() != null
                        ? result.getImage().getId()
                        : null,
                result.getImage() != null
                        ? result.getImage().getPath()
                        : null,
                result.getAddress(),
                result.getBusinessHours(),
                result.getTel(),
                result.isDeleted()
        );
    }
}