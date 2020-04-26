package source.domain.presenter.genre;

import source.controller.genres.crud.response.GenreResponseViewModels;
import source.domain.entity.db.Genres;

import java.util.List;

public interface IGenresMappingPresenter {
    GenreResponseViewModels mapping(List<Genres> genres);
}
