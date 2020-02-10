package source.usecases.app.coordinates.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.domain.entity.Clothes;
import source.domain.entity.Coordinates;
import source.domain.entity.Images;
import source.domain.repository.db.ClothesRepository;
import source.domain.repository.db.CoordinatesRepository;
import source.domain.repository.db.ImagesRepository;
import source.domain.repository.db.specification.CoordinatesSpecification;
import source.presenter.coordinates.ICoordinateMappingPresenter;
import source.presenter.coordinates.ICoordinatesMappingPresenter;
import source.usecases.app.coordinates.ICoordinateCrudUsecase;
import source.usecases.dto.request.coordinates.CoordinateCreateRequestModel;
import source.usecases.dto.request.coordinates.CoordinateUpdateRequestModel;
import source.usecases.dto.response.coordinates.CoordinateResponseViewModel;
import source.usecases.dto.response.coordinates.CoordinateResponseViewModels;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
@Transactional
public class AppCoordinateCrudInteractor implements ICoordinateCrudUsecase {
    @Autowired
    private CoordinatesRepository repository;

    @Autowired
    private ImagesRepository imagesRepository;

    @Autowired
    private ClothesRepository clothesRepository;

    @Autowired
    private ICoordinateMappingPresenter coordinateMappingPresenter;

    @Autowired
    private ICoordinatesMappingPresenter coordinatesMappingPresenter;

    @Override
    public CoordinateResponseViewModel create(Long userId, CoordinateCreateRequestModel inputData) {
        Images coordinateImage = Optional.ofNullable(inputData.getImageLink())
                .map(path -> this.imagesRepository.save(Images.builder().path(path).build()))
                .orElse(null);

        Set<Clothes> usedCoordinates = this.clothesRepository.findByIdIn(inputData.getClothingIds());

        Coordinates coordinates = Coordinates.builder()
                .userId(userId)
                .season(inputData.getSeason())
                .image(coordinateImage)
                .usedCoordinates(usedCoordinates)
                .build();

        return this.coordinateMappingPresenter.mapping(this.repository.save(coordinates));
    }

    @Override
    public void delete(Long id) {
        this.repository.delete(
                Coordinates
                        .builder()
                        .id(id)
                        .build()
        );
    }

    @Override
    public CoordinateResponseViewModels search(Long userId) {
        List<Coordinates> coordinates = this.repository.findAll(
                Specifications
                        .where(CoordinatesSpecification.userIdEqual(userId))
        );

        return this.coordinatesMappingPresenter.mapping(coordinates);
    }

    @Override
    public CoordinateResponseViewModel update(Long userId, Long id, CoordinateUpdateRequestModel inputData) {
        Images coordinateImage = Optional.ofNullable(inputData.getImageLink())
                .map(path -> {
                    Long imageId = Optional.ofNullable(inputData.getImageId()).orElse(null);
                    return this.imagesRepository.save(Images.builder().id(imageId).path(path).build());
                })
                .orElse(null);

        Set<Clothes> usedCoordinates = this.clothesRepository.findByIdIn(inputData.getClothingIds());

        Coordinates coordinates = Coordinates.builder()
                .id(id)
                .userId(userId)
                .season(inputData.getSeason())
                .image(coordinateImage)
                .usedCoordinates(usedCoordinates)
                .build();

        return this.coordinateMappingPresenter.mapping(this.repository.save(coordinates));
    }
}
