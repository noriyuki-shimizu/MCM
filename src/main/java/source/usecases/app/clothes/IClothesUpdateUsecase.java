package source.usecases.app.clothes;

import source.usecases.dto.request.clothes.ClothesUpdateRequestData;
import source.domain.entity.Clothes;

public interface IClothesUpdateUsecase {

    public Clothes update(Long userId, ClothesUpdateRequestData inputData);

}
