package source.controller.genres.crud.response;

import lombok.Data;
import lombok.Value;

@Value(staticConstructor = "of")
@Data
public class GenreResponseViewModel {
    private GenreResponseModel genre;
}
