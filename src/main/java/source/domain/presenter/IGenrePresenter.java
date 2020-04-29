package source.domain.presenter;

import source.controller.genres.assist.response.GenreColorResponseViewModels;
import source.controller.genres.assist.response.GenreKeyValueResponseViewModels;
import source.controller.genres.crud.response.GenreResponseViewModel;
import source.controller.genres.crud.response.GenreResponseViewModels;
import source.controller.genres.crud.response.TotalPricePerGenreViewModels;
import source.domain.entity.db.Genres;

import java.util.List;

public interface IGenrePresenter {
    GenreKeyValueResponseViewModels toGenreKeyValueResponseViewModels(final List<Genres> genres);
    GenreColorResponseViewModels toGenreColorResponseViewModels(final List<String> canSelectedColors);
    GenreResponseViewModel toGenreResponseViewModel(final Genres genre);
    GenreResponseViewModels toGenreResponseViewModels(final List<Genres> genres);
    TotalPricePerGenreViewModels toTotalPricePerGenreViewModels(final List<Genres> genres);
}
