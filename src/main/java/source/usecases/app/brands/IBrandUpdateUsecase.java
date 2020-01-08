package source.usecases.app.brands;

import source.usecases.dto.request.brands.BrandUpdateRequestData;
import source.usecases.dto.response.brands.BrandResponseModel;

public interface IBrandUpdateUsecase {
    public BrandResponseModel update(Long userId, BrandUpdateRequestData inputData);
}
