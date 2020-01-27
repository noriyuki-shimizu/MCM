package source.presenter.coordinates;

import source.domain.entity.Coordinates;
import source.usecases.dto.response.coordinates.CoordinateResponseViewModel;

public interface ICoordinateMappingPresenter {
    public CoordinateResponseViewModel mapping(Coordinates coordinate);
}
