package source.presenter.genre;

import source.domain.entity.Genres;
import source.controller.genres.crud.response.TotalPricePerGenreViewModels;

import java.util.List;

public interface ITotalPricePerGenrePresenter {
    TotalPricePerGenreViewModels mapping(List<Genres> genres);
}
