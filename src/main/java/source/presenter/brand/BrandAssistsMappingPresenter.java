package source.presenter.brand;

import org.springframework.stereotype.Component;
import source.controller.brands.assist.response.BrandAssistResponseModel;
import source.controller.brands.assist.response.BrandAssistResponseViewModels;
import source.domain.entity.db.Brands;
import source.domain.presenter.brand.IBrandAssistsMappingPresenter;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BrandAssistsMappingPresenter implements IBrandAssistsMappingPresenter {
    @Override
    public BrandAssistResponseViewModels mapping(List<Brands> brands) {
        List<BrandAssistResponseModel>  models = brands
                .stream()
                .map(brand -> BrandAssistResponseModel.of(brand.getId(), brand.getName()))
                .collect(Collectors.toList());

        return BrandAssistResponseViewModels.of(models);
    }
}
