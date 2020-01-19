package source.usecases.app.shops.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.entity.Images;
import source.presenter.shop.IShopMappingPresenter;
import source.usecases.dto.request.shops.ShopCreateRequestData;
import source.domain.entity.Shops;
import source.domain.repository.db.ShopsRepository;
import source.usecases.app.images.IImageSaveUsecase;
import source.usecases.app.shops.IShopCreateUsecase;
import source.usecases.dto.response.shops.ShopResponseViewModel;

import javax.transaction.Transactional;

@Component
@Transactional
public class ShopCreateInteractor implements IShopCreateUsecase {

    @Autowired
    private ShopsRepository repository;

    @Autowired
    private IImageSaveUsecase imageSaveUsecase;

    @Autowired
    private IShopMappingPresenter presenter;

    @Override
    public ShopResponseViewModel create(Long userId, ShopCreateRequestData inputData) {
        Images shopImage = this.imageSaveUsecase.save(null, inputData.getImageLink());

        Shops shop = Shops.builder()
                .userId(userId)
                .name(inputData.getName())
                .link(inputData.getLink())
                .stationName(inputData.getStationName())
                .image(shopImage)
                .address(inputData.getAddress())
                .businessHours(inputData.getBusinessHours())
                .tel(inputData.getTel())
                .build();

        Shops result = this.repository.save(shop);

        return this.presenter.mapping(result);
    }
}
