package source.presenter.brand;

import source.domain.entity.Brands;
import source.usecases.dto.response.brands.BrandResponseViewModels;

import java.util.List;

public interface IBrandsMappingPresenter {
    public BrandResponseViewModels mapping(List<Brands> brands);
}
