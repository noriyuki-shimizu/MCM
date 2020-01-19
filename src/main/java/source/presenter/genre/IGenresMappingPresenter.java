package source.presenter.genre;

import source.domain.entity.Genres;
import source.usecases.dto.response.genre.GenreResponseViewModels;

import java.util.List;

public interface IGenresMappingPresenter {
    public GenreResponseViewModels mapping(List<Genres> genres);
}
