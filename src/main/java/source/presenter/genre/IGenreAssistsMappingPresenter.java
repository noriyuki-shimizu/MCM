package source.presenter.genre;

import source.domain.entity.Genres;
import source.controller.genres.assist.response.GenreKeyValueResponseViewModels;

import java.util.List;

public interface IGenreAssistsMappingPresenter {
    public GenreKeyValueResponseViewModels mapping(List<Genres> genres);
}
