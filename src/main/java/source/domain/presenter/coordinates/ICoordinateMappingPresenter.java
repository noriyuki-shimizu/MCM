package source.domain.presenter.coordinates;

import source.controller.coordinates.curd.response.CoordinateResponseViewModel;
import source.domain.entity.db.Coordinates;

public interface ICoordinateMappingPresenter {
    CoordinateResponseViewModel mapping(final Coordinates coordinate);
}
