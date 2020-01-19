package source.presenter.brand;

import org.springframework.stereotype.Component;
import source.domain.entity.Brands;
import source.usecases.dto.response.brands.BrandResponseModel;
import source.usecases.dto.response.brands.BrandResponseViewModels;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BrandsMappingPresenter implements IBrandsMappingPresenter {
    @Override
    public BrandResponseViewModels mapping(List<Brands> brands) {
        List<BrandResponseModel> models = brands
                .stream()
                .map(brand -> BrandResponseModel.of(
                        brand.getId(),
                        brand.getName(),
                        brand.getLink(),
                        brand.getImage() != null
                                ? brand.getImage().getId()
                                : null,
                        brand.getImage() != null
                                ? brand.getImage().getPath()
                                : null,
                        brand.getCountry(),
                        brand.isDeleted()
                        )
                )
                .collect(Collectors.toList());

        return BrandResponseViewModels.of(models);
    }
}
