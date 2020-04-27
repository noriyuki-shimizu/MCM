package source.domain.presenter.genre;

import source.controller.genres.assist.response.GenreKeyValueResponseViewModels;
import source.domain.entity.db.Genres;

import java.util.List;

public interface IGenreAssistsMappingPresenter {
    GenreKeyValueResponseViewModels mapping(final List<Genres> genres);
}
