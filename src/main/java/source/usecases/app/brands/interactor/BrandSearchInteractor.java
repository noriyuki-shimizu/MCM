package source.usecases.app.brands.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.domain.entity.Brands;
import source.domain.repository.db.BrandsRepository;
import source.domain.repository.db.specification.BrandsSpecification;
import source.presenter.brand.IBrandsMappingPresenter;
import source.usecases.app.brands.IBrandSearchUsecase;
import source.usecases.dto.response.brands.BrandResponseViewModels;

import java.util.List;

@Component
public class BrandSearchInteractor implements IBrandSearchUsecase {

    @Autowired
    private BrandsRepository repository;

    @Autowired
    private IBrandsMappingPresenter presenter;

    @Override
    public BrandResponseViewModels search(Long userId) {
        List<Brands> brands = this.repository.findAll(
                Specifications
                        .where(BrandsSpecification.userIdEqual(userId))
        );

        return this.presenter.mapping(brands);
    }
}
