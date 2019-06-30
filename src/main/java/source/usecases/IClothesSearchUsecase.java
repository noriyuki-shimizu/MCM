package source.usecases;

import source.domain.dto.input.clothes.ClothesSearchInputData;
import source.domain.entity.MClothes;

import java.util.List;

public interface IClothesSearchUsecase {
    public List<MClothes> search(ClothesSearchInputData inputData);
}
