package source.usecases.app.clothes;

import source.usecases.dto.request.clothes.ClothesCreateRequestModel;
import source.usecases.dto.response.clothes.ClothesResponseViewModel;

public interface IClothesCreateUsecase {
    public ClothesResponseViewModel create(Long userId, ClothesCreateRequestModel inputData);
}
