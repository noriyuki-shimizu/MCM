package source.presenter.brand;

import org.springframework.stereotype.Component;
import source.domain.entity.Brands;
import source.controller.brands.assist.response.BrandAssistResponseModel;
import source.controller.brands.assist.response.BrandAssistResponseViewModels;

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
