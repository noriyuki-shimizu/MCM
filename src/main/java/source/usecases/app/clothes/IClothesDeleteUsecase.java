package source.usecases.app.clothes;

import source.usecases.dto.response.clothes.ClothesResponseViewModel;

public interface IClothesDeleteUsecase {
    public ClothesResponseViewModel delete(Long id);
}
