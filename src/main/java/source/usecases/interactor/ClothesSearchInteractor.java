package source.usecases.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.domain.dto.clothes.ClothesSearchInputData;
import source.domain.dto.clothes.ClothesSearchOutputData;
import source.domain.entity.list.MClothesList;
import source.domain.repository.MClothesRepository;
import source.domain.repository.specification.MClothesSpecification;
import source.usecases.IClothesSearchUsecase;

import java.util.List;

@Component
public class ClothesSearchInteractor implements IClothesSearchUsecase {

    @Autowired
    private MClothesRepository repository;

    public List<ClothesSearchOutputData> search(ClothesSearchInputData inputData) {
        MClothesList mClothesList = MClothesList.of(this.repository.findAll(
                Specifications
                        .where(MClothesSpecification.brandIdContains(inputData.getBrandId()))
                        .and(MClothesSpecification.shopIdEqual(inputData.getShopId()))
                        .and(MClothesSpecification.genreIdEqual(inputData.getGenreId()))
                        .and(MClothesSpecification.priceLessEqual(inputData.getLessPrice()))
                        .and(MClothesSpecification.priceGreaterEqual(inputData.getMorePrice()))
                        .and(MClothesSpecification.buyDateEqual(inputData.getBuyDate()))
                        .and(MClothesSpecification.deleteFlagEqual(inputData.isDeleteFlag()))
        ));

        return mClothesList.convertSearchOutputDatas();
    }
}
