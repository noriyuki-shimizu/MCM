package source.controller.genres.assist.response;

import lombok.Value;

import java.util.List;

@Value(staticConstructor = "of")
public class GenreColorResponseViewModels {
    private List<String> canSelectedColors;
}
