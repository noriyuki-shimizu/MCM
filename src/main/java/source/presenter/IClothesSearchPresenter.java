package source.presenter;

import source.domain.dto.clothes.ClothesSearchOutputData;
import source.domain.entity.MClothes;

import java.util.List;

public interface IClothesSearchPresenter {
    public List<ClothesSearchOutputData> handle(List<MClothes> mClothesList);
}
