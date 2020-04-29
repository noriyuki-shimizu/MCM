package source.domain.presenter;

import source.controller.coordinates.curd.response.CoordinateResponseViewModel;
import source.controller.coordinates.curd.response.CoordinateResponseViewModels;
import source.domain.entity.db.Coordinates;

import java.util.List;

public interface ICoordinatePresenter {
    CoordinateResponseViewModel toCoordinateResponseViewModel(final Coordinates coordinate);
    CoordinateResponseViewModels toCoordinateResponseViewModels(final List<Coordinates> coordinates);
}
