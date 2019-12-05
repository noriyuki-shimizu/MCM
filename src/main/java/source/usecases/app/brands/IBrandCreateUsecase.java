package source.usecases.app.brands;

import source.usecases.dto.input.brands.BrandCreateInputData;
import source.domain.entity.Brands;

public interface IBrandCreateUsecase {
    public Brands create(Long userId, BrandCreateInputData inputData);
}
