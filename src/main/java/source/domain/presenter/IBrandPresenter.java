package source.domain.presenter;

import source.controller.brands.assist.response.BrandAssistResponseViewModels;
import source.controller.brands.crud.response.BrandResponseViewModel;
import source.controller.brands.crud.response.BrandResponseViewModels;
import source.domain.entity.db.Brands;

import java.util.List;

public interface IBrandPresenter {
    BrandAssistResponseViewModels toBrandAssistResponseViewModels(final List<Brands> brands);
    BrandResponseViewModel toBrandResponseViewModel(final Brands brand);
    BrandResponseViewModels toBrandResponseViewModels(final List<Brands> brands);
}
