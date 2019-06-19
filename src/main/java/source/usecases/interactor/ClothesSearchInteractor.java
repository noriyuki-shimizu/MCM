package source.usecases.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.domain.dto.clothes.ClothesSearchInputData;
import source.domain.entity.MClothes;
import source.domain.repository.db.MClothesRepository;
import source.domain.repository.db.specification.MClothesSpecification;
import source.usecases.IClothesSearchUsecase;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class ClothesSearchInteractor implements IClothesSearchUsecase {

    @Autowired
    private MClothesRepository repository;

    public List<MClothes> search(ClothesSearchInputData inputData) {

        List<MClothes> mClothesList = this.repository.findAll(
                Specifications
                        .where(MClothesSpecification.brandIdContains(inputData.getBrandId()))
                        .and(MClothesSpecification.shopIdEqual(inputData.getShopId()))
                        .and(MClothesSpecification.genreIdEqual(inputData.getGenreId()))
                        .and(MClothesSpecification.priceLessEqual(inputData.getLessPrice()))
                        .and(MClothesSpecification.priceGreaterEqual(inputData.getMorePrice()))
                        .and(MClothesSpecification.buyDateEqual(inputData.getBuyDate()))
                        .and(MClothesSpecification.deleteFlagEqual(inputData.isDeleteFlag()))
        );

        return mClothesList;
    }
}
