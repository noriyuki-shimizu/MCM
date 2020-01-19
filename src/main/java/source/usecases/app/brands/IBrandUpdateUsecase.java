package source.usecases.app.brands;

import source.usecases.dto.request.brands.BrandUpdateRequestData;
import source.usecases.dto.response.brands.BrandResponseViewModel;

public interface IBrandUpdateUsecase {
    public BrandResponseViewModel update(
            Long userId,
            Long id,
            BrandUpdateRequestData inputData
    );
}
