package source.usecases.app.shops.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.usecases.dto.input.shops.ShopUpdateInputData;
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
    public Shops update(Long userId, ShopUpdateInputData inputData) {
        Shops shop = inputData.toEntity(userId);

        this.imageSaveUsecase.save(shop.getImage());

        return this.repository.save(shop);
    }
}