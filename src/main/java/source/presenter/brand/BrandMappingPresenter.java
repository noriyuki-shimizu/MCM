package source.presenter.brand;

import org.springframework.stereotype.Component;
import source.domain.entity.Brands;
import source.usecases.dto.response.brands.BrandResponseModel;
import source.usecases.dto.response.brands.BrandResponseViewModel;

@Component
public class BrandMappingPresenter implements IBrandMappingPresenter {
    @Override
    public BrandResponseViewModel mapping(Brands brand) {
        BrandResponseModel model = BrandResponseModel.of(
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
        );

        return BrandResponseViewModel.of(model);
    }
}
