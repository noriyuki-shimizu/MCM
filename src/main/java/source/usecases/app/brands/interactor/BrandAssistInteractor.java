package source.usecases.app.brands.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.domain.entity.Brands;
import source.domain.repository.db.BrandsRepository;
import source.domain.repository.db.specification.BrandsSpecification;
import source.presenter.brand.IBrandAssistsMappingPresenter;
import source.usecases.app.brands.IBrandAssistUsecase;
import source.usecases.dto.response.brands.BrandAssistResponseViewModels;

import java.util.List;

@Component
public class BrandAssistInteractor implements IBrandAssistUsecase {

    @Autowired
    private BrandsRepository repository;

    @Autowired
    private IBrandAssistsMappingPresenter presenter;

    @Override
    public BrandAssistResponseViewModels assist(Long userId) {
        List<Brands> brands = this.repository.findAll(
                Specifications
                        .where(BrandsSpecification.userIdEqual(userId))
                        .and(BrandsSpecification.isDeleted(false))
        );

        return this.presenter.mapping(brands);
    }
}
