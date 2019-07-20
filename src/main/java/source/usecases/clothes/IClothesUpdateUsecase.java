package source.usecases.clothes;

import source.domain.dto.input.clothes.ClothesUpdateInputData;
import source.domain.entity.Clothes;

public interface IClothesUpdateUsecase {

    public Clothes update(Long userId, ClothesUpdateInputData inputData);

}
