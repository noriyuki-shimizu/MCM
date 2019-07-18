package source.usecases.clothes;

import source.domain.dto.input.clothes.ClothesCreateInputData;
import source.domain.entity.Clothes;

public interface IClothesCreateUsecase {
    public Clothes create(Long userId, ClothesCreateInputData inputData);
}
