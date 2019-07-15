package source.usecases.brands.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.entity.Brands;
import source.domain.repository.db.BrandsRepository;
import source.usecases.brands.IBrandDeleteUsecase;

import javax.transaction.Transactional;

@Component
@Transactional
public class BrandDeleteInteractor implements IBrandDeleteUsecase {

    @Autowired
    private BrandsRepository repository;

    @Override
    public Brands delete(Long id) {
        return this.repository.deleteById(id);
    }
}
