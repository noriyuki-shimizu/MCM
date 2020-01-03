package source.usecases.app.brands;

import source.usecases.dto.request.brands.BrandCreateRequestData;
import source.domain.entity.Brands;

public interface IBrandCreateUsecase {
    public Brands create(Long userId, BrandCreateRequestData inputData);
}
