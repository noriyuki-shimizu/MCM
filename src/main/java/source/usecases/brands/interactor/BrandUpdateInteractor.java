package source.usecases.brands.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.dto.input.brands.BrandUpdateInputData;
import source.domain.entity.Brands;
import source.domain.repository.db.BrandsRepository;
import source.usecases.brands.IBrandUpdateUsecase;
import source.usecases.images.IImageSaveUsecase;

import javax.transaction.Transactional;

@Transactional
@Component
public class BrandUpdateInteractor implements IBrandUpdateUsecase {

    @Autowired
    private BrandsRepository repository;

    @Autowired
    private IImageSaveUsecase imageSaveUsecase;

    @Override
    public Brands update(Long userId, BrandUpdateInputData inputData) {
        Brands brand =  inputData.toEntity(userId);

        this.imageSaveUsecase.save(brand.getImage());

        return this.repository.save(brand);
    }
}
