package source.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.controller.coordinates.curd.request.CoordinateCreateRequestModel;
import source.controller.coordinates.curd.request.CoordinateUpdateRequestModel;
import source.controller.coordinates.curd.response.CoordinateResponseViewModel;
import source.controller.coordinates.curd.response.CoordinateResponseViewModels;
import source.domain.entity.db.Clothes;
import source.domain.entity.db.Coordinates;
import source.domain.entity.db.Images;
import source.domain.presenter.ICoordinatePresenter;
import source.domain.repository.db.ClothesRepository;
import source.domain.repository.db.CoordinatesRepository;
import source.domain.repository.db.ImagesRepository;
import source.usecases.app.ICoordinateCrudUsecase;

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
    private ICoordinatePresenter presenter;

    @Override
    public CoordinateResponseViewModel create(final Long userId, final CoordinateCreateRequestModel inputData) {
        final Images coordinateImage = Optional.ofNullable(inputData.getImageLink())
                .map(path -> imagesRepository.save(Images.builder().path(path).build()))
                .orElse(null);

        final Set<Clothes> usedCoordinates = clothesRepository.findByIdIn(inputData.getClothingIds());

        final Coordinates coordinates = Coordinates.builder()
                .userId(userId)
                .season(inputData.getSeason())
                .image(coordinateImage)
                .usedCoordinates(usedCoordinates)
                .build();

        return presenter.toCoordinateResponseViewModel(repository.save(coordinates));
    }

    @Override
    public void delete(final Long id) {
        repository.delete(
                Coordinates
                        .builder()
                        .id(id)
                        .build()
        );
    }

    @Override
    public CoordinateResponseViewModels search(final Long userId) {
        final List<Coordinates> coordinates = repository.findByUserIdOrderByIdAndSeason(userId);
        return presenter.toCoordinateResponseViewModels(coordinates);
    }

    @Override
    public CoordinateResponseViewModel searchById(final Long id) {
        final Coordinates coordinate = repository.findOne(id);
        return presenter.toCoordinateResponseViewModel(coordinate);
    }

    @Override
    public void update(final Long userId, final Long id, final CoordinateUpdateRequestModel inputData) {
        final Images coordinateImage = Optional.ofNullable(inputData.getImageLink())
                .map(path -> {
                    Long imageId = Optional.ofNullable(inputData.getImageId()).orElse(null);
                    return imagesRepository.save(Images.builder().id(imageId).path(path).build());
                })
                .orElse(null);

        final Set<Clothes> usedCoordinates = clothesRepository.findByIdIn(inputData.getClothingIds());

        final Coordinates coordinates = Coordinates.builder()
                .id(id)
                .userId(userId)
                .season(inputData.getSeason())
                .image(coordinateImage)
                .usedCoordinates(usedCoordinates)
                .build();

        repository.save(coordinates);
    }
}
