package source.usecases.app.brands;

import source.usecases.dto.response.brands.BrandAssistResponseViewModels;

public interface IBrandAssistUsecase {
    public BrandAssistResponseViewModels assist(Long userId);
}
