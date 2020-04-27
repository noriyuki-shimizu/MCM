package source.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.domain.entity.db.Clothes;
import source.domain.entity.db.Coordinates;
import source.domain.entity.db.Images;
import source.domain.presenter.coordinates.ICoordinateMappingPresenter;
import source.domain.presenter.coordinates.ICoordinatesMappingPresenter;
import source.domain.repository.db.ClothesRepository;
import source.domain.repository.db.CoordinatesRepository;
import source.domain.repository.db.ImagesRepository;
import source.domain.repository.db.specification.CoordinatesSpecification;
import source.usecases.app.ICoordinateCrudUsecase;
import source.controller.coordinates.curd.request.CoordinateCreateRequestModel;
import source.controller.coordinates.curd.request.CoordinateUpdateRequestModel;
import source.controller.coordinates.curd.response.CoordinateResponseViewModel;
import source.controller.coordinates.curd.response.CoordinateResponseViewModels;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
@Transactional
public class CoordinateCrudInteractor implements ICoordinateCrudUsecase {
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
    public CoordinateResponseViewModel create(final Long userId, final CoordinateCreateRequestModel inputData) {
        final Images coordinateImage = Optional.ofNullable(inputData.getImageLink())
                .map(path -> this.imagesRepository.save(Images.builder().path(path).build()))
                .orElse(null);

        final Set<Clothes> usedCoordinates = this.clothesRepository.findByIdIn(inputData.getClothingIds());

        final Coordinates coordinates = Coordinates.builder()
                .userId(userId)
                .season(inputData.getSeason())
                .image(coordinateImage)
                .usedCoordinates(usedCoordinates)
                .build();

        return this.coordinateMappingPresenter.mapping(this.repository.save(coordinates));
    }

    @Override
    public void delete(final Long id) {
        this.repository.delete(
                Coordinates
                        .builder()
                        .id(id)
                        .build()
        );
    }

    @Override
    public CoordinateResponseViewModels search(final Long userId) {
        final List<Coordinates> coordinates = this.repository.findAll(
                Specifications
                        .where(CoordinatesSpecification.userIdEqual(userId))
        );

        return this.coordinatesMappingPresenter.mapping(coordinates);
    }

    @Override
    public CoordinateResponseViewModel searchById(final Long id) {
        final Coordinates coordinate = this.repository.findOne(id);
        return this.coordinateMappingPresenter.mapping(coordinate);
    }

    @Override
    public void update(final Long userId, final Long id, final CoordinateUpdateRequestModel inputData) {
        final Images coordinateImage = Optional.ofNullable(inputData.getImageLink())
                .map(path -> {
                    Long imageId = Optional.ofNullable(inputData.getImageId()).orElse(null);
                    return this.imagesRepository.save(Images.builder().id(imageId).path(path).build());
                })
                .orElse(null);

        final Set<Clothes> usedCoordinates = this.clothesRepository.findByIdIn(inputData.getClothingIds());

        final Coordinates coordinates = Coordinates.builder()
                .id(id)
                .userId(userId)
                .season(inputData.getSeason())
                .image(coordinateImage)
                .usedCoordinates(usedCoordinates)
                .build();

        this.coordinateMappingPresenter.mapping(this.repository.save(coordinates));
    }
}
