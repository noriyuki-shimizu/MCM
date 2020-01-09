package source.usecases.app.shops.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.usecases.dto.request.shops.ShopUpdateRequestData;
import source.domain.entity.Shops;
import source.domain.repository.db.ShopsRepository;
import source.usecases.app.images.IImageSaveUsecase;
import source.usecases.app.shops.IShopUpdateUsecase;

import javax.transaction.Transactional;

@Component
@Transactional
public class ShopUpdateInteractor implements IShopUpdateUsecase {

    @Autowired
    private ShopsRepository repository;

    @Autowired
    private IImageSaveUsecase imageSaveUsecase;

    @Override
    public Shops update(Long userId, ShopUpdateRequestData inputData) {
        Shops shop = inputData.toEntity(userId);

        this.imageSaveUsecase.save(shop.getImage().getId(), shop.getImage().getPath());

        return this.repository.save(shop);
    }
}
