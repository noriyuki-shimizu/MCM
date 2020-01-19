package source.usecases.app.brands;

import source.usecases.dto.response.brands.BrandResponseViewModel;

public interface IBrandDeleteUsecase {
    public BrandResponseViewModel delete(Long id);
}
