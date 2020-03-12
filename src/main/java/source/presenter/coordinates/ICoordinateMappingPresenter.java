package source.presenter.coordinates;

import source.domain.entity.Coordinates;
import source.controller.coordinates.curd.response.CoordinateResponseViewModel;

public interface ICoordinateMappingPresenter {
    public CoordinateResponseViewModel mapping(Coordinates coordinate);
}
