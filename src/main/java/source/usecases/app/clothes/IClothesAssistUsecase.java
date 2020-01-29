package source.usecases.app.clothes;

import source.usecases.dto.response.clothes.ClothesAssistResponseViewModels;

public interface IClothesAssistUsecase {
    public ClothesAssistResponseViewModels assist(Long userId);
}
