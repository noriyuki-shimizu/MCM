package source.usecases.app.brands;

import source.usecases.dto.response.brands.BrandResponseModel;

public interface IBrandDeleteUsecase {
    public BrandResponseModel delete(Long id);
}
