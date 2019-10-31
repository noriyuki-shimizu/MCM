package source.usecases.brands.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.domain.dto.input.brands.BrandSearchInputData;
import source.domain.entity.Brands;
import source.domain.repository.db.BrandsRepository;
import source.domain.repository.db.specification.BrandsSpecification;
import source.usecases.brands.IBrandSearchUsecase;

import java.util.List;

@Component
public class BrandSearchInteractor implements IBrandSearchUsecase {

    @Autowired
    private BrandsRepository repository;

    @Override
    public List<Brands> search(Long userId, BrandSearchInputData inputData) {
        return this.repository.findAll(
                Specifications
                        .where(BrandsSpecification.userIdEqual(userId))
                        .and(BrandsSpecification.nameLike(inputData.getName()))
                        .and(BrandsSpecification.countryLike(inputData.getCountry()))
                        .and(BrandsSpecification.isDeletedEqual(inputData.getIsDeleted()))
        );
    }
}
