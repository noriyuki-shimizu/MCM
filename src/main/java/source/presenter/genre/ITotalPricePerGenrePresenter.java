package source.presenter.genre;

import source.domain.entity.Genres;
import source.usecases.dto.response.genre.TotalPricePerGenreViewModels;

import java.util.List;

public interface ITotalPricePerGenrePresenter {
    public TotalPricePerGenreViewModels mapping(List<Genres> genres);
}
