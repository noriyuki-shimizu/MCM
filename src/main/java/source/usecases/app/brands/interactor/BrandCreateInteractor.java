package source.usecases.app.brands.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.usecases.dto.request.brands.BrandCreateRequestData;
import source.domain.entity.Brands;
import source.domain.repository.db.BrandsRepository;
import source.usecases.app.brands.IBrandCreateUsecase;
import source.usecases.app.images.IImageSaveUsecase;

import javax.transaction.Transactional;

@Transactional
@Component
public class BrandCreateInteractor implements IBrandCreateUsecase {

    @Autowired
    private BrandsRepository repository;

    @Autowired
    private IImageSaveUsecase imageSaveUsecase;

    @Override
    public Brands create(Long userId, BrandCreateRequestData inputData) {
        Brands brand = inputData.toEntity(userId);

        brand.setImage(this.imageSaveUsecase.save(brand.getImage()));

        return this.repository.save(brand);
    }
}
