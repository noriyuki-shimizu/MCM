package source.usecases.app.brands.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.entity.Brands;
import source.domain.repository.db.BrandsRepository;
import source.usecases.app.brands.IBrandDeleteUsecase;
import source.usecases.dto.response.brands.BrandResponseModel;

import javax.transaction.Transactional;

@Component
@Transactional
public class BrandDeleteInteractor implements IBrandDeleteUsecase {

    @Autowired
    private BrandsRepository repository;

    @Override
    public BrandResponseModel delete(Long id) {
        Brands result = this.repository.deleteById(id);
        return BrandResponseModel.of(
                result.getId(),
                result.getName(),
                result.getLink(),
                result.getImage() != null
                        ? result.getImage().getId()
                        : null,
                result.getImage() != null
                        ? result.getImage().getPath()
                        : null,
                result.getCountry(),
                result.isDeleted()
        );
    }
}
