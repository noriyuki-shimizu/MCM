package source.usecases.app.brands.interactor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.domain.entity.Brands;
import source.domain.entity.Clothes;
import source.domain.entity.Images;
import source.domain.repository.db.BrandsRepository;
import source.domain.repository.db.ClothesRepository;
import source.domain.repository.db.specification.BrandsSpecification;
import source.domain.repository.db.specification.ClothesSpecification;
import source.presenter.brand.IBrandAssistsMappingPresenter;
import source.presenter.brand.IBrandMappingPresenter;
import source.presenter.brand.IBrandsMappingPresenter;
import source.usecases.app.brands.IBrandCrudUsecase;
import source.usecases.app.images.IImageSaveUsecase;
import source.usecases.dto.request.brands.BrandCreateRequestModel;
import source.usecases.dto.request.brands.BrandUpdateRequestModel;
import source.usecases.dto.response.brands.BrandAssistResponseViewModels;
import source.usecases.dto.response.brands.BrandResponseViewModel;
import source.usecases.dto.response.brands.BrandResponseViewModels;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
@Slf4j
public class AppBrandCrudInteractor implements IBrandCrudUsecase {
    @Autowired
    private BrandsRepository repository;

    @Autowired
    private ClothesRepository clothesRepository;

    @Autowired
    private IImageSaveUsecase imageSaveUsecase;

    @Autowired
    private IBrandAssistsMappingPresenter brandAssistsMappingPresenter;

    @Autowired
    private IBrandsMappingPresenter brandsMappingPresenter;

    @Autowired
    private IBrandMappingPresenter brandMappingPresenter;

    @Override
    public BrandAssistResponseViewModels acceptKeyValues(Long userId) {
        List<Brands> brands = this.repository.findAll(
                Specifications
                        .where(BrandsSpecification.userIdEqual(userId))
                        .and(BrandsSpecification.isDeleted(false))
        );

        return this.brandAssistsMappingPresenter.mapping(brands);
    }

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

        return this.brandMappingPresenter.mapping(result);
    }

    @Override
    public BrandResponseViewModel delete(Long id) {
        List<Clothes> clothes = this.clothesRepository.findAll(
                Specifications
                        .where(ClothesSpecification.brandIdContains(id))
        );
        if(clothes.size() > 0) {
            String errorMessage = "The brand cannot be deleted because it is used by other data.";
            log.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }

        Brands result = this.repository.deleteById(id);
        return this.brandMappingPresenter.mapping(result);
    }

    @Override
    public BrandResponseViewModel restoration(Long id) {
        Brands result = this.repository.restorationById(id);
        return this.brandMappingPresenter.mapping(result);
    }

    @Override
    public BrandResponseViewModels search(Long userId) {
        List<Brands> brands = this.repository.findAll(
                Specifications
                        .where(BrandsSpecification.userIdEqual(userId))
        );

        return this.brandsMappingPresenter.mapping(brands);
    }

    @Override
    public BrandResponseViewModel update(Long userId, Long id, BrandUpdateRequestModel inputData) {
        Images brandImage = this.imageSaveUsecase.save(
                inputData.getImageId(),
                inputData.getImageLink()
        );

        Brands brand = Brands.builder()
                .id(id)
                .userId(userId)
                .name(inputData.getName())
                .link(inputData.getLink())
                .image(brandImage)
                .country(inputData.getCountry())
                .build();

        Brands result = this.repository.save(brand);

        return this.brandMappingPresenter.mapping(result);
    }
}
