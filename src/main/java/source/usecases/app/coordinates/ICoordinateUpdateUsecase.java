package source.usecases.app.coordinates;

import source.usecases.dto.request.coordinates.CoordinateUpdateRequestModel;
import source.usecases.dto.response.coordinates.CoordinateResponseViewModel;

public interface ICoordinateUpdateUsecase {
    public CoordinateResponseViewModel update(Long userId, Long id, CoordinateUpdateRequestModel requestData);
}
