package source.usecases.app.shops.interactor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.domain.entity.Clothes;
import source.domain.entity.Images;
import source.domain.entity.Shops;
import source.domain.repository.db.ClothesRepository;
import source.domain.repository.db.ImagesRepository;
import source.domain.repository.db.ShopsRepository;
import source.domain.repository.db.specification.ClothesSpecification;
import source.domain.repository.db.specification.ShopsSpecification;
import source.presenter.shop.IShopAssistsMappingPresenter;
import source.presenter.shop.IShopMappingPresenter;
import source.presenter.shop.IShopsMappingPresenter;
import source.usecases.app.shops.IShopCrudUsecase;
import source.usecases.dto.request.shops.ShopCreateRequestModel;
import source.usecases.dto.request.shops.ShopUpdateRequestModel;
import source.usecases.dto.response.shops.ShopAssistResponseViewModels;
import source.usecases.dto.response.shops.ShopResponseViewModel;
import source.usecases.dto.response.shops.ShopResponseViewModels;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
@Slf4j
public class AppShopCrudInteractor implements IShopCrudUsecase {
    @Autowired
    private ShopsRepository repository;

    @Autowired
    private ClothesRepository clothesRepository;

    @Autowired
    private ImagesRepository imagesRepository;

    @Autowired
    private IShopAssistsMappingPresenter shopAssistsMappingPresenter;

    @Autowired
    private IShopMappingPresenter shopMappingPresenter;

    @Autowired
    private IShopsMappingPresenter shopsMappingPresenter;

    @Override
    public ShopAssistResponseViewModels acceptKeyValues(Long userId) {
        List<Shops> shops = this.repository.findAll(
                Specifications
                        .where(ShopsSpecification.userIdEqual(userId))
                        .and(ShopsSpecification.isDeleted(false))
        );

        return this.shopAssistsMappingPresenter.mapping(shops);
    }

    @Override
    public ShopResponseViewModel create(Long userId, ShopCreateRequestModel inputData) {
        Images shopImage = Optional.ofNullable(inputData.getImageLink())
                .map(path -> this.imagesRepository.save(Images.builder().path(path).build()))
                .orElse(null);

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

        return this.shopMappingPresenter.mapping(result);
    }

    @Override
    public ShopResponseViewModel delete(Long id) {
        List<Clothes> clothes = this.clothesRepository.findAll(
                Specifications
                        .where(ClothesSpecification.shopIdEqual(id))
        );
        if(clothes.size() > 0) {
            String errorMessage = "The shop cannot be deleted because it is used by other data.";
            log.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }

        Shops result = this.repository.deleteById(id);

        return this.shopMappingPresenter.mapping(result);
    }

    @Override
    public ShopResponseViewModels search(Long userId) {
        List<Shops> shops = this.repository.findAll(
                Specifications
                        .where(ShopsSpecification.userIdEqual(userId))
        );
        return this.shopsMappingPresenter.mapping(shops);
    }

    @Override
    public ShopResponseViewModel searchById(Long id) {
        Shops shop = this.repository.findOne(id);
        return this.shopMappingPresenter.mapping(shop);
    }

    @Override
    public ShopResponseViewModel update(Long userId, Long id, ShopUpdateRequestModel inputData) {
        Images shopImage = Optional.ofNullable(inputData.getImageLink())
                .map(path -> {
                    Long imageId = Optional.ofNullable(inputData.getImageId()).orElse(null);
                    return this.imagesRepository.save(Images.builder().id(imageId).path(path).build());
                })
                .orElse(null);

        Shops shop = Shops.builder()
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

        Shops result = this.repository.save(shop);

        return this.shopMappingPresenter.mapping(result);
    }

    @Override
    public ShopResponseViewModel restoration(Long id) {
        Shops result = this.repository.restorationById(id);
        return this.shopMappingPresenter.mapping(result);
    }
}
