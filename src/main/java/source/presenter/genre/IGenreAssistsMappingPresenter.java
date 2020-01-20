package source.presenter.genre;

import source.domain.entity.Genres;
import source.usecases.dto.response.genre.GenreAssistResponseViewModels;

import java.util.List;

public interface IGenreAssistsMappingPresenter {
    public GenreAssistResponseViewModels mapping(List<Genres> genres);
}
