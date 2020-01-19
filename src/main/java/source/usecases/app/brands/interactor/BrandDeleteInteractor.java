package source.usecases.app.brands.interactor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.domain.entity.Brands;
import source.domain.entity.Clothes;
import source.domain.repository.db.BrandsRepository;
import source.domain.repository.db.ClothesRepository;
import source.domain.repository.db.specification.ClothesSpecification;
import source.presenter.brand.IBrandMappingPresenter;
import source.usecases.app.brands.IBrandDeleteUsecase;
import source.usecases.dto.response.brands.BrandResponseViewModel;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
@Slf4j
public class BrandDeleteInteractor implements IBrandDeleteUsecase {

    @Autowired
    private BrandsRepository repository;

    @Autowired
    private ClothesRepository clothesRepository;

    @Autowired
    private IBrandMappingPresenter presenter;

    @Override
    public BrandResponseViewModel delete(Long id) {
        List<Clothes> clothes = this.clothesRepository.findAll(
                Specifications
                    .where(ClothesSpecification.brandIdContains(id))
        );
        if(clothes != null && clothes.size() > 0) {
            String errorMessage = "The brand cannot be deleted because it is used by other data.";
            log.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }

        Brands result = this.repository.deleteById(id);
        return this.presenter.mapping(result);
    }
}
