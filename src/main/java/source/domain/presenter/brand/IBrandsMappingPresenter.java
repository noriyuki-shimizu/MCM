package source.domain.presenter.brand;

import source.controller.brands.crud.response.BrandResponseViewModels;
import source.domain.entity.db.Brands;

import java.util.List;

public interface IBrandsMappingPresenter {
    BrandResponseViewModels mapping(List<Brands> brands);
}
