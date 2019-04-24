package source.usecases.interactor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.domain.convert.clothes.ClothesSearchOutputDataConvert;
import source.domain.dto.clothes.ClothesSearchInputData;
import source.domain.entity.MClothes;
import source.domain.repository.MClothesRepository;
import source.domain.repository.specification.MClothesSpecification;
import source.usecases.IClothesSearchUsecase;

import java.util.List;

@Component
public class ClothesSearchInteractor implements IClothesSearchUsecase {

    @Autowired
    private MClothesRepository repository;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public String search(ClothesSearchInputData inputData) {
        List<MClothes> outputDataList = this.repository.findAll(
                Specifications
                        .where(MClothesSpecification.brandIdContains(inputData.getBrandId()))
                        .and(MClothesSpecification.shopIdEqual(inputData.getShopId()))
                        .and(MClothesSpecification.genreIdEqual(inputData.getGenreId()))
                        .and(MClothesSpecification.priceLessEqual(inputData.getLessPrice()))
                        .and(MClothesSpecification.priceGreaterEqual(inputData.getMorePrice()))
                        .and(MClothesSpecification.buyDateEqual(inputData.getBuyDate()))
                        .and(MClothesSpecification.deleteFlagEqual(inputData.isDeleteFlag()))
        );

        try {
            ClothesSearchOutputDataConvert convert = ClothesSearchOutputDataConvert.of(outputDataList);

            return MAPPER.writeValueAsString(convert.execution());
        } catch(JsonProcessingException jpe) {
            jpe.printStackTrace();
            return null;
        }
    }
}
