package source.interactor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.controller.brands.assist.response.BrandAssistResponseViewModels;
import source.controller.brands.crud.request.BrandCreateRequestModel;
import source.controller.brands.crud.request.BrandUpdateRequestModel;
import source.controller.brands.crud.response.BrandResponseViewModel;
import source.controller.brands.crud.response.BrandResponseViewModels;
import source.domain.entity.db.Brands;
import source.domain.entity.db.Clothes;
import source.domain.entity.db.Images;
import source.domain.presenter.IBrandPresenter;
import source.domain.repository.db.BrandsRepository;
import source.domain.repository.db.ClothesRepository;
import source.domain.repository.db.ImagesRepository;
import source.domain.repository.db.specification.ClothesSpecification;
import source.usecases.app.IBrandCrudUsecase;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
@Slf4j
public class BrandCrudInteractor implements IBrandCrudUsecase {
    @Autowired
    private BrandsRepository repository;

    @Autowired
    private ClothesRepository clothesRepository;

    @Autowired
    private ImagesRepository imagesRepository;

    @Autowired
    private IBrandPresenter presenter;

    @Override
    public BrandAssistResponseViewModels acceptKeyValues(final Long userId) {
        final List<Brands> brands = repository.findByUserIdAndIsDeletedOrderByName(userId, false);

        return presenter.toBrandAssistResponseViewModels(brands);
    }

    @Override
    public BrandResponseViewModel create(final Long userId, final BrandCreateRequestModel inputData) {
        final Images brandImages = Optional.ofNullable(inputData.getImageLink())
                .map(path -> imagesRepository.save(Images.builder().path(path).build()))
                .orElse(null);

        final Brands brand = Brands.builder()
                .userId(userId)
                .name(inputData.getName())
                .link(inputData.getLink())
                .image(brandImages)
                .country(inputData.getCountry())
                .build();

        final Brands result = repository.save(brand);

        return presenter.toBrandResponseViewModel(result);
    }

    @Override
    public void delete(final Long id) {
        final List<Clothes> clothes = clothesRepository.findAll(
                Specifications
                        .where(ClothesSpecification.brandIdContains(id))
        );
        if(clothes.size() > 0) {
            final String errorMessage = "The brand cannot be deleted because it is used by other data.";
            log.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }

        repository.deleteById(id);
    }

    @Override
    public void restoration(final Long id) {
        repository.restorationById(id);
    }

    @Override
    public BrandResponseViewModels search(final Long userId) {
        final List<Brands> brands = repository.findByUserIdOrderByName(userId);

        return presenter.toBrandResponseViewModels(brands);
    }

    @Override
    public BrandResponseViewModel searchById(final Long id) {
        final Brands brand = repository.findOne(id);

        return presenter.toBrandResponseViewModel(brand);
    }

    @Override
    public void update(final Long userId, final Long id, final BrandUpdateRequestModel inputData) {
        final Images brandImage = Optional.ofNullable(inputData.getImageLink())
                .map(path -> {
                    Long imageId = Optional.ofNullable(inputData.getImageId()).orElse(null);
                    return imagesRepository.save(Images.builder().id(imageId).path(path).build());
                })
                .orElse(null);

        final Brands brand = Brands.builder()
                .id(id)
                .userId(userId)
                .name(inputData.getName())
                .link(inputData.getLink())
                .image(brandImage)
                .country(inputData.getCountry())
                .build();

        repository.save(brand);
    }
}
