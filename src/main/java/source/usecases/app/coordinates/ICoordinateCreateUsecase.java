package source.usecases.app.coordinates;

import source.usecases.dto.request.coordinates.CoordinateCreateRequestModel;
import source.usecases.dto.response.coordinates.CoordinateResponseViewModel;

public interface ICoordinateCreateUsecase {
    public CoordinateResponseViewModel create(Long userId, CoordinateCreateRequestModel requestData);
}
