package source.usecases.app.brands;

import source.usecases.dto.request.brands.BrandCreateRequestData;
import source.usecases.dto.response.brands.BrandResponseViewModel;

public interface IBrandCreateUsecase {
    public BrandResponseViewModel create(Long userId, BrandCreateRequestData inputData);
}
