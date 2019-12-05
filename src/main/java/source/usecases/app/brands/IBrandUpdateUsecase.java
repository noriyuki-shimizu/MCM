package source.usecases.app.brands;

import source.usecases.dto.input.brands.BrandUpdateInputData;
import source.domain.entity.Brands;

public interface IBrandUpdateUsecase {
    public Brands update(Long userId, BrandUpdateInputData inputData);
}
