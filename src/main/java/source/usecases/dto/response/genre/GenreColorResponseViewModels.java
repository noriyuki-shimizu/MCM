package source.usecases.dto.response.genre;

import lombok.Value;

import java.util.List;

@Value(staticConstructor = "of")
public class GenreColorResponseViewModels {
    private List<String> canSelectedColors;
}
