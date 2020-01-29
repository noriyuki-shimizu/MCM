package source.presenter.brand;

import org.springframework.stereotype.Component;
import source.domain.entity.Brands;
import source.domain.entity.Images;
import source.usecases.dto.response.brands.BrandResponseModel;
import source.usecases.dto.response.brands.BrandResponseViewModel;

import java.util.Optional;

@Component
public class BrandMappingPresenter implements IBrandMappingPresenter {
    @Override
    public BrandResponseViewModel mapping(Brands brand) {
        BrandResponseModel model = BrandResponseModel.of(
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
}
