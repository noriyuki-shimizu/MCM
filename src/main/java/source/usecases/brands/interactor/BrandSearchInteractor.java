package source.usecases.brand.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import source.domain.dto.input.brands.BrandSearchInputData;
import source.domain.entity.Brands;
import source.domain.repository.db.BrandsRepository;
import source.domain.repository.db.specification.BrandSpecification;
import source.usecases.brand.IBrandSearchUsecase;

import java.util.List;

public class BrandSearchInteractor implements IBrandSearchUsecase {

    @Autowired
    private BrandsRepository repository;

    @Override
    public List<Brands> search(BrandSearchInputData inputData) {
        System.out.println(inputData.isDeleted());
        return this.repository.findAll(
                Specifications
                        .where(BrandSpecification.nameLike(inputData.getName()))
                        .and(BrandSpecification.countryEqual(inputData.getCountry()))
                        .and(BrandSpecification.isDeletedEqual(inputData.isDeleted()))
        );
    }
}
