package source.usecases;

import source.domain.dto.clothes.ClothesSearchInputData;

public interface IClothesSearchUsecase {
    public String search(ClothesSearchInputData inputData);
}
