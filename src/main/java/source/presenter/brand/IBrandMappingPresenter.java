package source.presenter.brand;

import source.domain.entity.Brands;
import source.controller.brands.crud.response.BrandResponseViewModel;

public interface IBrandMappingPresenter {
    BrandResponseViewModel mapping(Brands brand);
}
