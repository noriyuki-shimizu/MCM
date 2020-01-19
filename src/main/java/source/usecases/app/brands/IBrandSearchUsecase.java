package source.usecases.app.brands;

import source.usecases.dto.response.brands.BrandResponseViewModels;

import java.util.List;

public interface IBrandSearchUsecase {
    public BrandResponseViewModels search(Long userId);
}
