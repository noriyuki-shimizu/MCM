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
import source.domain.presenter.IClothesPresenter;
import source.domain.repository.db.*;
import source.domain.repository.db.specification.ClothesSpecification;
import source.domain.repository.db.specification.CoordinatesSpecification;
import source.usecases.app.IClothesCrudUsecase;
import source.usecases.converter.BuyDate;

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
        final List<Clothes> clothes = this.repository.findByUserIdAndIsDeleted(userId, false);
        return this.presenter.toClothesAssistResponseViewModels(clothes);
    }

    @Override
    public ClothesResponseViewModel create(final Long userId, final ClothesCreateRequestModel inputData) {
        final Images clothesImage = Optional.ofNullable(inputData.getImageLink())
                .map(path -> this.imagesRepository.save(Images.builder().path(path).build()))
                .orElse(null);

        // TODO: JPA での闇の実装（もっと調査する必要あり）
        final Brands brand = this.brandsRepository.findOne(inputData.getBrandId());

        final Shops shop = this.shopsRepository.findOne(inputData.getShopId());

        final Set<Genres> genres = this.genresRepository.findByIdIn(
                inputData.getGenreIds()
        );

        final Clothes result = this.repository.save(
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

        return this.presenter.toClothesResponseViewModel(result);
    }

    @Override
    public void delete(final Long id) {
        final List<Coordinates> coordinates = this.coordinatesRepository.findAll(
                Specifications
                        .where(CoordinatesSpecification.hasClothes(id))
        );
        if (coordinates.size() > 0) {
            final String errorMessage = "The clothes cannot be deleted because it is used by other data.";
            log.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }

        this.repository.deleteById(id);
    }

    @Override
    public void restoration(final Long id) {
        this.repository.restorationById(id);
    }

    @Override
    public ClothesResponseViewModels search(final Long userId) {
        final List<Clothes> clothes = this.repository.findAll(
                Specifications
                        .where(ClothesSpecification.userIdEqual(userId))
        );
        return this.presenter.toClothesResponseViewModels(clothes);
    }

    @Override
    public ClothesResponseViewModel searchById(final Long id) {
        final Clothes clothes = this.repository.findOne(id);
        return this.presenter.toClothesResponseViewModel(clothes);
    }

    @Override
    public long getTotalPriceByUserId(final Long userId) {
        return this.repository.sumPriceByUserId(userId);
    }

    @Override
    public void update(final Long userId, final Long id, final ClothesUpdateRequestModel inputData) {
        final Images clothesImage = Optional.ofNullable(inputData.getImageLink())
                .map(path -> {
                    Long imageId = Optional.ofNullable(inputData.getImageId()).orElse(null);
                    return this.imagesRepository.save(Images.builder().id(imageId).path(path).build());
                })
                .orElse(null);

        // TODO: JPA での闇の実装（もっと調査する必要あり）
        final Brands brand = this.brandsRepository.findOne(inputData.getBrandId());

        final Shops shop = this.shopsRepository.findOne(inputData.getShopId());

        final Set<Genres> genres = this.genresRepository.findByIdIn(
                inputData.getGenreIds()
        );

        this.repository.save(
                Clothes.builder()
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
                        .build()
        );
    }
}
