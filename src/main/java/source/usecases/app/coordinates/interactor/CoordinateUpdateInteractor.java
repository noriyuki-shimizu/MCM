package source.usecases.app.coordinates.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.entity.Clothes;
import source.domain.entity.Coordinates;
import source.domain.entity.Images;
import source.domain.repository.db.ClothesRepository;
import source.domain.repository.db.CoordinatesRepository;
import source.presenter.coordinates.ICoordinateMappingPresenter;
import source.usecases.app.coordinates.ICoordinateUpdateUsecase;
import source.usecases.app.images.IImageSaveUsecase;
import source.usecases.dto.request.coordinates.CoordinateUpdateRequestModel;
import source.usecases.dto.response.coordinates.CoordinateResponseViewModel;

import javax.transaction.Transactional;
import java.util.Set;

@Component
@Transactional
public class CoordinateUpdateInteractor implements ICoordinateUpdateUsecase {
    @Autowired
    private CoordinatesRepository repository;

    @Autowired
    private IImageSaveUsecase imageSaveUsecase;

    @Autowired
    private ClothesRepository clothesRepository;

    @Autowired
    private ICoordinateMappingPresenter presenter;

    @Override
    public CoordinateResponseViewModel update(Long userId, Long id, CoordinateUpdateRequestModel requestData) {
        Images coordinateImage = this.imageSaveUsecase.save(requestData.getImageId(), requestData.getImageLink());

        Set<Clothes> usedCoordinates = this.clothesRepository.findByIdIn(requestData.getClothingIds());

        Coordinates coordinates = Coordinates.builder()
                .id(id)
                .userId(userId)
                .season(requestData.getSeason())
                .image(coordinateImage)
                .usedCoordinates(usedCoordinates)
                .build();

        return this.presenter.mapping(this.repository.save(coordinates));
    }
}
