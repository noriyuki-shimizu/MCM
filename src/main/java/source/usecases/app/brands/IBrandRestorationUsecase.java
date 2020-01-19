package source.usecases.app.brands;

import source.usecases.dto.response.brands.BrandResponseViewModel;

public interface IBrandRestorationUsecase {
    public BrandResponseViewModel restoration(Long id);
}
