package source.usecases.app.brands.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.usecases.dto.request.brands.BrandUpdateRequestData;
import source.domain.entity.Brands;
import source.domain.repository.db.BrandsRepository;
import source.usecases.app.brands.IBrandUpdateUsecase;
import source.usecases.app.images.IImageSaveUsecase;

import javax.transaction.Transactional;

@Transactional
@Component
public class BrandUpdateInteractor implements IBrandUpdateUsecase {

    @Autowired
    private BrandsRepository repository;

    @Autowired
    private IImageSaveUsecase imageSaveUsecase;

    @Override
    public Brands update(Long userId, BrandUpdateRequestData inputData) {
        Brands brand =  inputData.toEntity(userId);

        brand.setImage(this.imageSaveUsecase.save(brand.getImage()));

        return this.repository.save(brand);
    }
}
