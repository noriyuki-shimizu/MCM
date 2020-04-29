package source.presenter;

import org.springframework.stereotype.Component;
import source.controller.brands.assist.response.BrandAssistResponseModel;
import source.controller.brands.assist.response.BrandAssistResponseViewModels;
import source.controller.brands.crud.response.BrandResponseModel;
import source.controller.brands.crud.response.BrandResponseViewModel;
import source.controller.brands.crud.response.BrandResponseViewModels;
import source.domain.entity.db.Brands;
import source.domain.entity.db.Images;
import source.domain.presenter.IBrandPresenter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BrandPresenter implements IBrandPresenter {
    @Override
    public BrandAssistResponseViewModels toBrandAssistResponseViewModels(List<Brands> brands) {
        final List<BrandAssistResponseModel>  models = brands
                .stream()
                .map(brand -> BrandAssistResponseModel.of(brand.getId(), brand.getName()))
                .collect(Collectors.toList());

        return BrandAssistResponseViewModels.of(models);
    }

    @Override
    public BrandResponseViewModel toBrandResponseViewModel(Brands brand) {
        final BrandResponseModel model = BrandResponseModel.of(
                brand.getId(),
                brand.getName(),
                brand.getLink(),
                Optional.ofNullable(brand.getImage())
                        .map(Images::getId)
                        .orElse(null),
                Optional.ofNullable(brand.getImage())
                        .map(Images::getPath)
                        .orElse(null),
                brand.getCountry(),
                brand.isDeleted()
        );

        return BrandResponseViewModel.of(model);
    }

    @Override
    public BrandResponseViewModels toBrandResponseViewModels(List<Brands> brands) {
        final List<BrandResponseModel> models = brands
                .stream()
                .map(brand -> BrandResponseModel.of(
                        brand.getId(),
                        brand.getName(),
                        brand.getLink(),
                        Optional.ofNullable(brand.getImage())
                                .map(Images::getId)
                                .orElse(null),
                        Optional.ofNullable(brand.getImage())
                                .map(Images::getPath)
                                .orElse(null),
                        brand.getCountry(),
                        brand.isDeleted()
                        )
                )
                .collect(Collectors.toList());

        return BrandResponseViewModels.of(models);
    }
}
