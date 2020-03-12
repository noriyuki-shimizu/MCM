package source.presenter.genre;

import source.domain.entity.Genres;
import source.controller.genres.crud.response.GenreResponseViewModels;

import java.util.List;

public interface IGenresMappingPresenter {
    GenreResponseViewModels mapping(List<Genres> genres);
}
