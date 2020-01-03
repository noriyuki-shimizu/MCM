package source.usecases.app.brands;

import source.usecases.dto.request.brands.BrandUpdateRequestData;
import source.domain.entity.Brands;

public interface IBrandUpdateUsecase {
    public Brands update(Long userId, BrandUpdateRequestData inputData);
}
