package source.usecases.dto.response.coordinates;

import lombok.Value;

@Value(staticConstructor = "of")
public class CoordinateResponseViewModel {
    private CoordinateResponseModel coordinate;
}
