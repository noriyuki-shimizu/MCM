package source.usecases.app.brands.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.entity.Images;
import source.domain.vo.BrandUpdateData;
import source.usecases.dto.request.brands.BrandUpdateRequestData;
import source.domain.entity.Brands;
import source.domain.repository.db.BrandsRepository;
import source.usecases.app.brands.IBrandUpdateUsecase;
import source.usecases.app.images.IImageSaveUsecase;
import source.usecases.dto.response.brands.BrandResponseModel;

import javax.transaction.Transactional;

@Transactional
@Component
public class BrandUpdateInteractor implements IBrandUpdateUsecase {

    @Autowired
    private BrandsRepository repository;

    @Autowired
    private IImageSaveUsecase imageSaveUsecase;

    @Override
    public BrandResponseModel update(Long userId, BrandUpdateRequestData inputData) {
        BrandUpdateData data = BrandUpdateData.of(
                userId,
                inputData.getId(),
                inputData.getName(),
                inputData.getLink(),
                inputData.getImageLink(),
                inputData.getCountry()
        );
        Brands brand =  data.toEntity();

        Images brandImage = this.imageSaveUsecase.save(brand.getImage());

        brand.setImage(brandImage);

        Brands result = this.repository.save(brand);

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
