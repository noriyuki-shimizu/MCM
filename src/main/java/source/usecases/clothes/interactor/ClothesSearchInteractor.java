package source.usecases.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.domain.dto.input.clothes.ClothesSearchInputData;
import source.domain.entity.Clothes;
import source.domain.repository.db.ClothesRepository;
import source.domain.repository.db.specification.ClothesSpecification;
import source.usecases.IClothesSearchUsecase;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class ClothesSearchInteractor implements IClothesSearchUsecase {

    @Autowired
    private ClothesRepository repository;

    public List<Clothes> search(ClothesSearchInputData inputData) {

        List<Clothes> clothesList = this.repository.findAll(
                Specifications
                        .where(ClothesSpecification.brandIdContains(inputData.getBrandId()))
                        .and(ClothesSpecification.shopIdEqual(inputData.getShopId()))
                        .and(ClothesSpecification.genreIdEqual(inputData.getGenreId()))
                        .and(ClothesSpecification.priceLessEqual(inputData.getLessPrice()))
                        .and(ClothesSpecification.priceGreaterEqual(inputData.getMorePrice()))
                        .and(ClothesSpecification.buyDateEqual(inputData.getBuyDate()))
                        .and(ClothesSpecification.deleteFlagEqual(inputData.isDeleteFlag()))
        );

        return clothesList;
    }
}
