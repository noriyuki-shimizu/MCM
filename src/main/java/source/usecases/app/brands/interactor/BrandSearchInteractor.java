package source.usecases.app.brands.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.domain.entity.Brands;
import source.domain.repository.db.BrandsRepository;
import source.domain.repository.db.specification.BrandsSpecification;
import source.usecases.app.brands.IBrandSearchUsecase;
import source.usecases.dto.response.brands.BrandResponseModel;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BrandSearchInteractor implements IBrandSearchUsecase {

    @Autowired
    private BrandsRepository repository;

    @Override
    public List<BrandResponseModel> search(Long userId) {
        List<Brands> brands = this.repository.findAll(
                Specifications
                        .where(BrandsSpecification.userIdEqual(userId))
        );

        return brands.stream()
                .map(brand -> BrandResponseModel.of(
                        brand.getId(),
                        brand.getName(),
                        brand.getLink(),
                        brand.getImage() != null
                                ? brand.getImage().getPath()
                                : null,
                        brand.getCountry(),
                        brand.isDeleted()
                        )
                )
                .collect(Collectors.toList());
    }
}
