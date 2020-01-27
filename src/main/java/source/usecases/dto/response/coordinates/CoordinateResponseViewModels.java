package source.usecases.dto.response.coordinates;

import lombok.Value;

import java.util.List;

@Value(staticConstructor = "of")
public class CoordinateResponseViewModels {
    private List<CoordinateResponseModel> coordinates;
}
