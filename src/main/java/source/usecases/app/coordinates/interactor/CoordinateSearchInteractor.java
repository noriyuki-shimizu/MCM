package source.usecases.app.coordinates.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.domain.entity.Coordinates;
import source.domain.repository.db.CoordinatesRepository;
import source.domain.repository.db.specification.CoordinatesSpecification;
import source.presenter.coordinates.ICoordinatesMappingPresenter;
import source.usecases.app.coordinates.ICoordinateSearchUsecase;
import source.usecases.dto.response.coordinates.CoordinateResponseViewModels;

import java.util.List;

@Component
public class CoordinateSearchInteractor implements ICoordinateSearchUsecase {
    @Autowired
    private CoordinatesRepository repository;

    @Autowired
    private ICoordinatesMappingPresenter presenter;

    @Override
    public CoordinateResponseViewModels search(Long userId) {
        List<Coordinates> coordinates = this.repository.findAll(
                Specifications
                    .where(CoordinatesSpecification.userIdEqual(userId))
        );

        return this.presenter.mapping(coordinates);
    }
}
