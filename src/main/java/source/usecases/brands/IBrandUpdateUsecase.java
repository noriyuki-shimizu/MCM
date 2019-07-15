package source.usecases.brands;

import source.domain.dto.input.brands.BrandUpdateInputData;
import source.domain.entity.Brands;

public interface IBrandUpdateUsecase {
    public Brands update(Long userId, BrandUpdateInputData inputData);
}
