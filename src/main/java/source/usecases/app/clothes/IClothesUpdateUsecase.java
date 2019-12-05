package source.usecases.app.clothes;

import source.usecases.dto.input.clothes.ClothesUpdateInputData;
import source.domain.entity.Clothes;

public interface IClothesUpdateUsecase {

    public Clothes update(Long userId, ClothesUpdateInputData inputData);

}
