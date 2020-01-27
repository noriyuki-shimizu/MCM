package source.usecases.app.coordinates.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.entity.Coordinates;
import source.domain.repository.db.CoordinatesRepository;
import source.usecases.app.coordinates.ICoordinateDeleteUsecase;

import javax.transaction.Transactional;

@Component
@Transactional
public class CoordinateDeleteInteractor implements ICoordinateDeleteUsecase {
    @Autowired
    private CoordinatesRepository repository;

    @Override
    public void delete(Long id) {
        this.repository.delete(
                Coordinates
                .builder()
                .id(id)
                .build()
        );
    }
}
