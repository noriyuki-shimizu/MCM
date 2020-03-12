package source.presenter.brand;

import source.domain.entity.Brands;
import source.controller.brands.crud.response.BrandResponseViewModels;

import java.util.List;

public interface IBrandsMappingPresenter {
    public BrandResponseViewModels mapping(List<Brands> brands);
}
