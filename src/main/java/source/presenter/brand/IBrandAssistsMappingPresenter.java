package source.presenter.brand;

import source.domain.entity.Brands;
import source.controller.brands.assist.response.BrandAssistResponseViewModels;

import java.util.List;

public interface IBrandAssistsMappingPresenter {
    public BrandAssistResponseViewModels mapping(List<Brands> brands);
}
