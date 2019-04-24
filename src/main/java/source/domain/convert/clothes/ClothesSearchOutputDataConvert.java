package source.domain.convert.clothes;

import lombok.Value;
import source.domain.dto.clothes.ClothesSearchOutputData;
import source.domain.entity.MClothes;

import java.util.ArrayList;
import java.util.List;

@Value(staticConstructor = "of")
public class ClothesSearchOutputDataConvert {

    private List<MClothes> targets;

    public List<ClothesSearchOutputData> execution() {
        List<ClothesSearchOutputData> outputDataList = new ArrayList<>();
        targets.forEach(target -> {
            ClothesSearchOutputData outputData = ClothesSearchOutputData.builder()
                    .imagePath(target.getMImage().getPath())
                    .genreName(target.getMGenre().getName())
                    .brandName(target.getMBrand().getName())
                    .shopName(target.getMShop().getName())
                    .price(target.getPrice())
                    .buyDate(target.getBuyDate())
                    .deleteFlag(target.isDeleteFlag())
                    .build();

            outputDataList.add(outputData);
        });

        return outputDataList;
    }

}
