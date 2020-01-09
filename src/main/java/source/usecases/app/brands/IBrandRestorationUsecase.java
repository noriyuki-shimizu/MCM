package source.usecases.app.brands;

import source.usecases.dto.response.brands.BrandResponseModel;

public interface IBrandRestorationUsecase {
    public BrandResponseModel restoration(Long id);
}
