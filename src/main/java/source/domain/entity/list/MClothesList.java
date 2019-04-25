package source.domain.entity.list;

import lombok.Value;
import source.domain.dto.clothes.ClothesSearchOutputData;
import source.domain.entity.MClothes;

import java.util.List;
import java.util.stream.Collectors;

@Value(staticConstructor = "of")
public class MClothesList {

    private List<MClothes> values;

    public List<ClothesSearchOutputData> convertSearchOutputDatas() {
        return this.values.stream().map(value -> {

            return ClothesSearchOutputData.builder()
                    .imagePath(value.getMImage().getPath())
                    .genreName(value.getMGenre().getName())
                    .brandName(value.getMBrand().getName())
                    .shopName(value.getMShop().getName())
                    .price(value.getPrice())
                    .buyDate(value.getBuyDate())
                    .deleteFlag(value.isDeleteFlag())
                    .build();

        }).collect(Collectors.toList());
    }
}
