package source.domain.presenter.genre;

import source.controller.genres.crud.response.TotalPricePerGenreViewModels;
import source.domain.entity.db.Genres;

import java.util.List;

public interface ITotalPricePerGenrePresenter {
    TotalPricePerGenreViewModels mapping(final List<Genres> genres);
}
