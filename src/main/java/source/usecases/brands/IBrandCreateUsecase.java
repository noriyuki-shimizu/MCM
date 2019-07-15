package source.usecases.brands;

import source.domain.dto.input.brands.BrandCreateInputData;
import source.domain.entity.Brands;

public interface IBrandCreateUsecase {
    public Brands create(Long userId, BrandCreateInputData inputData);
}
