package source.usecases.app.clothes;

import source.usecases.dto.request.clothes.ClothesUpdateRequestModel;
import source.usecases.dto.response.clothes.ClothesResponseViewModel;

public interface IClothesUpdateUsecase {

    public ClothesResponseViewModel update(Long userId, Long id, ClothesUpdateRequestModel inputData);

}
