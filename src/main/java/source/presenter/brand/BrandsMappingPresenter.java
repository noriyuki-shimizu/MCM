package source.presenter.brand;

import org.springframework.stereotype.Component;
import source.domain.entity.db.Brands;
import source.domain.entity.db.Images;
import source.controller.brands.crud.response.BrandResponseModel;
import source.controller.brands.crud.response.BrandResponseViewModels;
import source.domain.presenter.brand.IBrandsMappingPresenter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BrandsMappingPresenter implements IBrandsMappingPresenter {
    @Override
    public BrandResponseViewModels mapping(final List<Brands> brands) {
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
