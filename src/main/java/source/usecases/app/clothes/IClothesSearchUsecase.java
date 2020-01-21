package source.usecases.app.clothes;

import source.usecases.dto.response.clothes.ClothesResponseViewModels;

public interface IClothesSearchUsecase {
    public ClothesResponseViewModels search(Long userId);
}
