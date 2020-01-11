package source.usecases.dto.response.genre;

import lombok.Data;
import lombok.Value;

import java.util.List;

@Value(staticConstructor = "of")
@Data
public class GenreResponseViewModels {
    private List<GenreResponseModel> genres;
}
