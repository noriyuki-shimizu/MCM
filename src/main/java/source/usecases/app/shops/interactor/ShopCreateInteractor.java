package source.usecases.app.shops.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.usecases.dto.input.shops.ShopCreateInputData;
import source.domain.entity.Shops;
import source.domain.repository.db.ShopsRepository;
import source.usecases.app.images.IImageSaveUsecase;
import source.usecases.app.shops.IShopCreateUsecase;

import javax.transaction.Transactional;

@Component
@Transactional
public class ShopCreateInteractor implements IShopCreateUsecase {

    @Autowired
    private ShopsRepository repository;

    @Autowired
    private IImageSaveUsecase imageSaveUsecase;

    @Override
    public Shops create(Long userId, ShopCreateInputData inputData) {
        Shops shop = inputData.toEntity(userId);

        shop.setImage(this.imageSaveUsecase.save(shop.getImage()));

        return this.repository.save(shop);
    }
}
