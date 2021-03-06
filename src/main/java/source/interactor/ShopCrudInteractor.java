package source.interactor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.controller.shops.assist.response.ShopAssistResponseViewModels;
import source.controller.shops.crud.request.ShopCreateRequestModel;
import source.controller.shops.crud.request.ShopUpdateRequestModel;
import source.controller.shops.crud.response.ShopResponseViewModel;
import source.controller.shops.crud.response.ShopResponseViewModels;
import source.domain.entity.db.Clothes;
import source.domain.entity.db.Images;
import source.domain.entity.db.Shops;
import source.domain.logging.CrudLogging;
import source.domain.logging.LoggingHead;
import source.domain.presenter.IShopPresenter;
import source.domain.repository.db.ClothesRepository;
import source.domain.repository.db.ImagesRepository;
import source.domain.repository.db.ShopsRepository;
import source.domain.repository.db.specification.ClothesSpecification;
import source.usecases.IShopCrudUsecase;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
@Slf4j
public class ShopCrudInteractor implements IShopCrudUsecase {
    @Autowired
    private ShopsRepository repository;

    @Autowired
    private ClothesRepository clothesRepository;

    @Autowired
    private ImagesRepository imagesRepository;

    @Autowired
    private IShopPresenter presenter;

    @Override
    public ShopAssistResponseViewModels acceptKeyValues(final Long userId) {
        final List<Shops> shops = repository.findByUserIdAndIsDeletedOrderByName(userId, false);

        return presenter.toShopAssistResponseViewModels(shops);
    }

    @Override
    public ShopResponseViewModel create(final Long userId, final ShopCreateRequestModel inputData) {
        final Images shopImage = Optional.ofNullable(inputData.getImageLink())
                .map(path -> imagesRepository.save(Images.builder().path(path).build()))
                .orElse(null);

        final Shops shop = Shops.builder()
                .userId(userId)
                .name(inputData.getName())
                .link(inputData.getLink())
                .stationName(inputData.getStationName())
                .image(shopImage)
                .address(inputData.getAddress())
                .businessHours(inputData.getBusinessHours())
                .tel(inputData.getTel())
                .build();

        final Shops result = repository.save(shop);

        CrudLogging.logging(LoggingHead.SHOP_CREATE, userId, result);

        return presenter.toShopResponseViewModel(result);
    }

    @Override
    public void delete(final Long userId, final Long id) {
        final List<Clothes> clothes = clothesRepository.findAll(
                Specifications
                        .where(ClothesSpecification.shopIdEqual(id))
        );
        if(clothes.size() > 0) {
            final String errorMessage = "The shop cannot be deleted because it is used by other data.";
            log.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }

        repository.deleteById(id);

        CrudLogging.logging(LoggingHead.SHOP_DELETE, userId, id);
    }

    @Override
    public ShopResponseViewModels search(final Long userId) {
        final List<Shops> shops = repository.findByUserIdOrderByName(userId);

        return presenter.toShopResponseViewModels(shops);
    }

    @Override
    public ShopResponseViewModel searchById(final Long id) {
        final Shops shop = repository.findOne(id);
        return presenter.toShopResponseViewModel(shop);
    }

    @Override
    public void update(final Long userId, final Long id, final ShopUpdateRequestModel inputData) {
        final Images shopImage = Optional.ofNullable(inputData.getImageLink())
                .map(path -> {
                    Long imageId = Optional.ofNullable(inputData.getImageId()).orElse(null);
                    return imagesRepository.save(Images.builder().id(imageId).path(path).build());
                })
                .orElse(null);

        final Shops shop = Shops.builder()
                .id(id)
                .userId(userId)
                .name(inputData.getName())
                .link(inputData.getLink())
                .stationName(inputData.getStationName())
                .image(shopImage)
                .address(inputData.getAddress())
                .businessHours(inputData.getBusinessHours())
                .tel(inputData.getTel())
                .build();

        repository.save(shop);

        CrudLogging.logging(LoggingHead.SHOP_UPDATE, userId, shop);
    }

    @Override
    public void restoration(final Long userId, final Long id) {
        CrudLogging.logging(LoggingHead.SHOP_RESTORATION, userId, id);
        repository.restorationById(id);
    }
}
