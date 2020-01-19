package source.presenter.brand;

import source.domain.entity.Brands;
import source.usecases.dto.response.brands.BrandResponseViewModel;

public interface IBrandMappingPresenter {
    public BrandResponseViewModel mapping(Brands brand);
}
