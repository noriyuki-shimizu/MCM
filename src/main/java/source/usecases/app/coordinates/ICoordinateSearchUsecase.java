package source.usecases.app.coordinates;

import source.usecases.dto.response.coordinates.CoordinateResponseViewModels;

public interface ICoordinateSearchUsecase {
    public CoordinateResponseViewModels search(Long userId);
}
