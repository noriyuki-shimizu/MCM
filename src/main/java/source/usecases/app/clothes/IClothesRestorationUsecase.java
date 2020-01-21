package source.usecases.app.clothes;

import source.usecases.dto.response.clothes.ClothesResponseViewModel;

public interface IClothesRestorationUsecase {
    public ClothesResponseViewModel restoration(Long id);
}
