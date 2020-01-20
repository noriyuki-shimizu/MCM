package source.usecases.dto.response.genre;

import lombok.Data;
import lombok.Value;

@Value(staticConstructor = "of")
@Data
public class GenreAssistResponseModel {
    private Long id;

    private String name;

    private String color;
}
