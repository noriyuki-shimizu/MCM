package source.presenter.genre;

import org.springframework.stereotype.Component;
import source.controller.genres.assist.response.GenreColorResponseViewModels;
import source.domain.presenter.genre.IGenreColorMappingPresenter;

import java.util.List;

@Component
public class GenreColorMappingPresenter implements IGenreColorMappingPresenter {
    @Override
    public GenreColorResponseViewModels mapping(final List<String> canSelectedColors) {
        return GenreColorResponseViewModels.of(canSelectedColors);
    }
}
