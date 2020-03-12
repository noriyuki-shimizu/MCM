package source.controller.genres.assist.response;

import lombok.Data;
import lombok.Value;

@Value(staticConstructor = "of")
@Data
public class GenreKeyValueResponseModel {
    private Long id;

    private String name;

    private String color;
}
