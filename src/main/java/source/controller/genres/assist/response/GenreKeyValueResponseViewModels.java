package source.controller.genres.assist.response;

import lombok.Value;

import java.util.List;

@Value(staticConstructor = "of")
public class GenreKeyValueResponseViewModels {
    private List<GenreKeyValueResponseModel> assistGenres;
}
