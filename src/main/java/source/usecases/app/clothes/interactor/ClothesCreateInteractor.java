package source.usecases.app.clothes.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.entity.*;
import source.domain.repository.db.ClothesRepository;
import source.presenter.clothes.IClothesMappingPresenter;
import source.usecases.app.clothes.IClothesCreateUsecase;
import source.usecases.app.images.IImageSaveUsecase;
import source.usecases.dto.request.clothes.ClothesCreateRequestModel;
import source.usecases.dto.response.clothes.ClothesResponseViewModel;

import javax.transaction.Transactional;
import java.time.ZoneId;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Transactional
public class ClothesCreateInteractor implements IClothesCreateUsecase {

    @Autowired
    private ClothesRepository repository;

    @Autowired
    private IImageSaveUsecase imageSaveUsecase;

    @Autowired
    private IClothesMappingPresenter presenter;

    @Override
    public ClothesResponseViewModel create(Long userId, ClothesCreateRequestModel inputData) {
        Images clothesImage = this.imageSaveUsecase.save(null, inputData.getImageLink());

        Set<Genres> genres = inputData.getGenreIds()
                .stream()
                .map(genreId -> Genres.builder().id(genreId).build())
                .collect(Collectors.toSet());

        Date buyDate = Date.from(
                inputData
                        .getBuyDate()
                        .atStartOfDay(ZoneId.systemDefault())
                        .toInstant()
        );

        Clothes clothes = Clothes.builder()
                .userId(userId)
                .image(clothesImage)
                .genres(genres)
                .brand(Brands.builder().id(inputData.getBrandId()).build())
                .shop(Shops.builder().id(inputData.getShopId()).build())
                .price(inputData.getPrice())
                .buyDate(buyDate)
                .comment(inputData.getComment())
                .satisfaction(inputData.getSatisfaction())
                .build();

        Clothes result = this.repository.save(clothes);

        return this.presenter.mapping(result);
    }

}
