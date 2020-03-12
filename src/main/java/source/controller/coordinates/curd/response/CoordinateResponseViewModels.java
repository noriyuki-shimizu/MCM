package source.controller.coordinates.curd.response;

import lombok.Value;

import java.util.List;

@Value(staticConstructor = "of")
public class CoordinateResponseViewModels {
    private List<CoordinateResponseModel> coordinates;
}
