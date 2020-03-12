package source.controller.coordinates.curd.response;

import lombok.Data;
import lombok.Value;
import source.controller.clothes.assist.response.ClothesAssistResponseModel;

import java.util.Set;

@Value(staticConstructor = "of")
@Data
public class CoordinateResponseModel {
    private Long id;

    private String season;

    private Long imageId;

    private String imageLink;

    private Set<ClothesAssistResponseModel> usedCoordinates;
}
