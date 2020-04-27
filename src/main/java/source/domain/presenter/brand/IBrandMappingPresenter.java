package source.domain.presenter.brand;

import source.controller.brands.crud.response.BrandResponseViewModel;
import source.domain.entity.db.Brands;

public interface IBrandMappingPresenter {
    BrandResponseViewModel mapping(final Brands brand);
}
