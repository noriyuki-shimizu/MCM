package source.domain.presenter.brand;

import source.controller.brands.assist.response.BrandAssistResponseViewModels;
import source.domain.entity.db.Brands;

import java.util.List;

public interface IBrandAssistsMappingPresenter {
    BrandAssistResponseViewModels mapping(final List<Brands> brands);
}
