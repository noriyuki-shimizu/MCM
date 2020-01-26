package source.usecases.app.clothes.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.entity.*;
import source.domain.repository.db.BrandsRepository;
import source.domain.repository.db.ClothesRepository;
import source.domain.repository.db.GenresRepository;
import source.domain.repository.db.ShopsRepository;
import source.presenter.clothes.IClothesMappingPresenter;
import source.usecases.app.clothes.IClothesCreateUsecase;
import source.usecases.app.images.IImageSaveUsecase;
import source.usecases.converter.BuyDate;
import source.usecases.dto.request.clothes.ClothesCreateRequestModel;
import source.usecases.dto.response.clothes.ClothesResponseViewModel;

import javax.transaction.Transactional;
import java.util.Set;

@Component
@Transactional
public class ClothesCreateInteractor implements IClothesCreateUsecase {

    @Autowired
    private ClothesRepository repository;

    @Autowired
    private IImageSaveUsecase imageSaveUsecase;

    @Autowired
    private BrandsRepository brandsRepository;

    @Autowired
    private ShopsRepository shopsRepository;

    @Autowired
    private GenresRepository genresRepository;

    @Autowired
    private IClothesMappingPresenter presenter;

    @Override
    public ClothesResponseViewModel create(Long userId, ClothesCreateRequestModel inputData) {
        Images clothesImage = this.imageSaveUsecase.save(null, inputData.getImageLink());

        // TODO: JPA での闇の実装（もっと調査する必要あり）
        Brands brand = this.brandsRepository.findOne(inputData.getBrandId());

        Shops shop = this.shopsRepository.findOne(inputData.getShopId());

        Set<Genres> genres = this.genresRepository.findByIdIn(
                inputData.getGenreIds()
        );

        Clothes clothes = Clothes.builder()
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

        Clothes result = this.repository.save(clothes);

        return this.presenter.mapping(result);
    }

}
