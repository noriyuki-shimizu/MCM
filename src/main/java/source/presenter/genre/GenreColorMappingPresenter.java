package source.presenter.genre;

import org.springframework.stereotype.Component;
import source.usecases.dto.response.genre.GenreColorResponseViewModels;

import java.util.List;

@Component
public class GenreColorMappingPresenter implements IGenreColorMappingPresenter {
    @Override
    public GenreColorResponseViewModels mapping(List<String> canSelectedColors) {
        return GenreColorResponseViewModels.of(canSelectedColors);
    }
}
