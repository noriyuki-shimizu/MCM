package source.usecases.dto.response.genre;

import lombok.Data;
import lombok.Value;

@Value(staticConstructor = "of")
@Data
public class ClothesGenreResponseModel {
    private String name;

    private String color;
}
