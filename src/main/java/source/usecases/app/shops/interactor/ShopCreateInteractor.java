package source.usecases.app.shops.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.entity.Images;
import source.usecases.dto.request.shops.ShopCreateRequestData;
import source.domain.entity.Shops;
import source.domain.repository.db.ShopsRepository;
import source.usecases.app.images.IImageSaveUsecase;
import source.usecases.app.shops.IShopCreateUsecase;
import source.usecases.dto.response.shops.ShopResponseModel;

import javax.transaction.Transactional;

@Component
@Transactional
public class ShopCreateInteractor implements IShopCreateUsecase {

    @Autowired
    private ShopsRepository repository;

    @Autowired
    private IImageSaveUsecase imageSaveUsecase;

    @Override
    public ShopResponseModel create(Long userId, ShopCreateRequestData inputData) {
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
                result.isDeleted()
        );
    }
}
