package source.usecases.dto.response.coordinates;

import lombok.Data;
import lombok.Value;
import source.usecases.dto.response.clothes.ClothesAssistResponseModel;

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
