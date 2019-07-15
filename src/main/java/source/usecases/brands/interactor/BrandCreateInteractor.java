package source.usecases.brands.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.dto.input.brands.BrandCreateInputData;
import source.domain.entity.Brands;
import source.domain.repository.db.BrandsRepository;
import source.usecases.brands.IBrandCreateUsecase;
import source.usecases.images.IImageSaveUsecase;

import javax.transaction.Transactional;

@Transactional
@Component
public class BrandCreateInteractor implements IBrandCreateUsecase {

    @Autowired
    private BrandsRepository repository;

    @Autowired
    private IImageSaveUsecase imageCreateUsecase;

    @Override
    public Brands create(Long userId, BrandCreateInputData inputData) {
        Brands brand = inputData.toEntity(userId);

        brand.setImage(this.imageCreateUsecase.save(brand.getImage()));

        return this.repository.save(brand);
    }
}
