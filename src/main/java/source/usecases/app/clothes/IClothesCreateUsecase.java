package source.usecases.app.clothes;

import source.usecases.dto.request.clothes.ClothesCreateRequestData;
import source.domain.entity.Clothes;

public interface IClothesCreateUsecase {
    public Clothes create(Long userId, ClothesCreateRequestData inputData);
}
