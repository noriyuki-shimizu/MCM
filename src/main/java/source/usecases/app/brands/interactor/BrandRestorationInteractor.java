package source.usecases.app.brands.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.entity.Brands;
import source.domain.repository.db.BrandsRepository;
import source.presenter.brand.IBrandMappingPresenter;
import source.usecases.app.brands.IBrandRestorationUsecase;
import source.usecases.dto.response.brands.BrandResponseViewModel;

import javax.transaction.Transactional;

@Component
@Transactional
public class BrandRestorationInteractor implements IBrandRestorationUsecase {
    @Autowired
    private BrandsRepository repository;

    @Autowired
    private IBrandMappingPresenter presenter;

    @Override
    public BrandResponseViewModel restoration(Long id) {
        Brands result = this.repository.restorationById(id);
        return this.presenter.mapping(result);
    }
}
