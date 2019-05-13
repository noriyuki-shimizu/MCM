package source.presenter.interactor;

import org.springframework.stereotype.Component;
import source.domain.dto.clothes.ClothesSearchOutputData;
import source.domain.entity.MClothes;
import source.presenter.IClothesSearchPresenter;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClothesSearchPresenter implements IClothesSearchPresenter {

    @Override
    public List<ClothesSearchOutputData> handle(List<MClothes> mClothesList) {
        return mClothesList.stream().map(clothes -> {

            return ClothesSearchOutputData.builder()
                    .id(clothes.getId())
                    .imagePath(clothes.getMImage().getPath())
                    .genreName(clothes.getMGenre().getName())
                    .brandName(clothes.getMBrand().getName())
                    .shopName(clothes.getMShop().getName())
                    .price(clothes.getPrice())
                    .buyDate(clothes.getBuyDate())
                    .deleteFlag(clothes.isDeleteFlag())
                    .build();

        }).collect(Collectors.toList());
    }

}
