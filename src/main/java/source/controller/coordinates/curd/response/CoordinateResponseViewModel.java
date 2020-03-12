package source.controller.coordinates.curd.response;

import lombok.Value;

@Value(staticConstructor = "of")
public class CoordinateResponseViewModel {
    private CoordinateResponseModel coordinate;
}
