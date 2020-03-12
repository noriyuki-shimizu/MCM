package source.presenter.brand;

import source.domain.entity.Brands;
import source.controller.brands.crud.response.BrandResponseViewModel;

public interface IBrandMappingPresenter {
    public BrandResponseViewModel mapping(Brands brand);
}
