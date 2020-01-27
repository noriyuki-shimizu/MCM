package source.presenter.coordinates;

import source.domain.entity.Coordinates;
import source.usecases.dto.response.coordinates.CoordinateResponseViewModels;

import java.util.List;

public interface ICoordinatesMappingPresenter {
    public CoordinateResponseViewModels mapping(List<Coordinates> clothes);
}
