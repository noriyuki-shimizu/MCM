package source.usecases.app.clothes;

import source.usecases.dto.input.clothes.ClothesCreateInputData;
import source.domain.entity.Clothes;

public interface IClothesCreateUsecase {
    public Clothes create(Long userId, ClothesCreateInputData inputData);
}
