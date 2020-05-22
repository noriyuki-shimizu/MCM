package source.interactor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.controller.clothes.assist.response.ClothesAssistResponseViewModels;
import source.controller.clothes.curd.request.ClothesCreateRequestModel;
import source.controller.clothes.curd.request.ClothesUpdateRequestModel;
import source.controller.clothes.curd.response.ClothesResponseViewModel;
import source.controller.clothes.curd.response.ClothesResponseViewModels;
import source.domain.entity.db.*;
import source.domain.logging.CrudLogging;
import source.domain.logging.LoggingHead;
import source.domain.presenter.IClothesPresenter;
import source.domain.repository.db.*;
import source.domain.repository.db.specification.CoordinatesSpecification;
import source.usecases.IClothesCrudUsecase;
import source.converter.BuyDate;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
@Transactional
@Slf4j
public class ClothesCrudInteractor implements IClothesCrudUsecase {
    @Autowired
    private ClothesRepository repository;

    @Autowired
    private ImagesRepository imagesRepository;

    @Autowired
    private CoordinatesRepository coordinatesRepository;

    @Autowired
    private BrandsRepository brandsRepository;

    @Autowired
    private ShopsRepository shopsRepository;

    @Autowired
    private GenresRepository genresRepository;

    @Autowired
    private IClothesPresenter presenter;

    @Override
    public ClothesAssistResponseViewModels acceptKeyValues(final Long userId) {
        final List<Clothes> clothes = repository.findByUserIdAndIsDeletedOrderByBrandIdAscShopIdAsc(userId, false);
        return presenter.toClothesAssistResponseViewModels(clothes);
    }

    @Override
    public ClothesResponseViewModel create(final Long userId, final ClothesCreateRequestModel inputData) {
        final Images clothesImage = Optional.ofNullable(inputData.getImageLink())
                .map(path -> imagesRepository.save(Images.builder().path(path).build()))
                .orElse(null);

        // TODO: JPA での闇の実装（もっと調査する必要あり）
        final Brands brand = brandsRepository.findOne(inputData.getBrandId());

        final Shops shop = shopsRepository.findOne(inputData.getShopId());

        final Set<Genres> genres = genresRepository.findByIdIn(
                inputData.getGenreIds()
        );

        final Clothes result = repository.save(
                Clothes.builder()
                        .userId(userId)
                        .image(clothesImage)
                        .genres(genres)
                        .brand(brand)
                        .shop(shop)
                        .price(inputData.getPrice())
                        .buyDate(BuyDate.toSqlDate(inputData.getBuyDate()))
                        .comment(inputData.getComment())
                        .satisfaction(inputData.getSatisfaction())
                        .build()
        );

        CrudLogging.logging(LoggingHead.CLOTHES_CREATE, userId, result);

        return presenter.toClothesResponseViewModel(result);
    }

    @Override
    public void delete(final Long userId, final Long id) {
        final List<Coordinates> coordinates = coordinatesRepository.findAll(
                Specifications
                        .where(CoordinatesSpecification.hasClothes(id))
        );
        if (coordinates.size() > 0) {
            final String errorMessage = "The clothes cannot be deleted because it is used by other data.";
            log.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }

        CrudLogging.logging(LoggingHead.CLOTHES_DELETE, userId, id);

        repository.deleteById(id);
    }

    @Override
    public void restoration(final Long userId, final Long id) {
        CrudLogging.logging(LoggingHead.CLOTHES_RESTORATION, userId, id);
        repository.restorationById(id);
    }

    @Override
    public ClothesResponseViewModels search(final Long userId) {
        final List<Clothes> clothes = repository.findByUserIdOrderByBrandIdAscShopIdAsc(userId);

        return presenter.toClothesResponseViewModels(clothes);
    }

    @Override
    public ClothesResponseViewModel searchById(final Long id) {
        final Clothes clothes = repository.findOne(id);
        return presenter.toClothesResponseViewModel(clothes);
    }

    @Override
    public long getTotalPriceByUserId(final Long userId) {
        return repository.sumPriceByUserId(userId);
    }

    @Override
    public void update(final Long userId, final Long id, final ClothesUpdateRequestModel inputData) {
        final Images clothesImage = Optional.ofNullable(inputData.getImageLink())
                .map(path -> {
                    Long imageId = Optional.ofNullable(inputData.getImageId()).orElse(null);
                    return imagesRepository.save(Images.builder().id(imageId).path(path).build());
                })
                .orElse(null);

        // TODO: JPA での闇の実装（もっと調査する必要あり）
        final Brands brand = brandsRepository.findOne(inputData.getBrandId());

        final Shops shop = shopsRepository.findOne(inputData.getShopId());

        final Set<Genres> genres = genresRepository.findByIdIn(
                inputData.getGenreIds()
        );

        Clothes clothes = Clothes.builder()
                .id(id)
                .userId(userId)
                .image(clothesImage)
                .genres(genres)
                .brand(brand)
                .shop(shop)
                .price(inputData.getPrice())
                .buyDate(BuyDate.toSqlDate(inputData.getBuyDate()))
                .comment(inputData.getComment())
                .satisfaction(inputData.getSatisfaction())
                .build();

        repository.save(clothes);

        CrudLogging.logging(LoggingHead.CLOTHES_UPDATE, userId, clothes);
    }
}
