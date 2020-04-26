package source.domain.presenter.coordinates;

import source.controller.coordinates.curd.response.CoordinateResponseViewModels;
import source.domain.entity.db.Coordinates;

import java.util.List;

public interface ICoordinatesMappingPresenter {
    CoordinateResponseViewModels mapping(List<Coordinates> clothes);
}
