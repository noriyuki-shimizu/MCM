package source.usecases.app.clothes.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.entity.*;
import source.domain.repository.db.ClothesRepository;
import source.presenter.clothes.IClothesMappingPresenter;
import source.usecases.app.clothes.IClothesUpdateUsecase;
import source.usecases.app.images.IImageSaveUsecase;
import source.usecases.converter.BuyDate;
import source.usecases.dto.request.clothes.ClothesUpdateRequestModel;
import source.usecases.dto.response.clothes.ClothesResponseViewModel;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ClothesUpdateInteractor implements IClothesUpdateUsecase {

    @Autowired
    private ClothesRepository repository;

    @Autowired
    private IImageSaveUsecase imageSaveUsecase;

    @Autowired
    private IClothesMappingPresenter presenter;

    @Override
    public ClothesResponseViewModel update(Long userId, Long id, ClothesUpdateRequestModel inputData) {
        Images clothesImage = this.imageSaveUsecase.save(
                inputData.getImageId(),
                inputData.getImageLink()
        );

        Set<Genres> genres = inputData.getGenreIds()
                .stream()
                .map(genreId -> Genres.builder().id(genreId).build())
                .collect(Collectors.toSet());

        Clothes clothes = Clothes.builder()
                .id(id)
                .userId(userId)
                .image(clothesImage)
                .genres(genres)
                .brand(Brands.builder().id(inputData.getBrandId()).build())
                .shop(Shops.builder().id(inputData.getShopId()).build())
                .price(inputData.getPrice())
                .buyDate(BuyDate.toSqlDate(inputData.getBuyDate()))
                .comment(inputData.getComment())
                .satisfaction(inputData.getSatisfaction())
                .build();

        Clothes result = this.repository.save(clothes);

        return this.presenter.mapping(result);
    }
}
