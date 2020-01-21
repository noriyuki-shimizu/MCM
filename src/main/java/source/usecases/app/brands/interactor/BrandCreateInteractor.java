package source.usecases.app.brands.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.entity.Images;
import source.presenter.brand.IBrandMappingPresenter;
import source.usecases.dto.request.brands.BrandCreateRequestModel;
import source.domain.entity.Brands;
import source.domain.repository.db.BrandsRepository;
import source.usecases.app.brands.IBrandCreateUsecase;
import source.usecases.app.images.IImageSaveUsecase;
import source.usecases.dto.response.brands.BrandResponseViewModel;

import javax.transaction.Transactional;

@Transactional
@Component
public class BrandCreateInteractor implements IBrandCreateUsecase {

    @Autowired
    private BrandsRepository repository;

    @Autowired
    private IImageSaveUsecase imageSaveUsecase;

    @Autowired
    private IBrandMappingPresenter presenter;

    @Override
    public BrandResponseViewModel create(Long userId, BrandCreateRequestModel inputData) {
        Images brandImages = this.imageSaveUsecase.save(null, inputData.getImageLink());

        Brands brand = Brands.builder()
                .userId(userId)
                .name(inputData.getName())
                .link(inputData.getLink())
                .image(brandImages)
                .country(inputData.getCountry())
                .build();

        Brands result = this.repository.save(brand);

        return this.presenter.mapping(result);
    }
}
