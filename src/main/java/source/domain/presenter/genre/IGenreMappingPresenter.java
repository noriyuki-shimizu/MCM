package source.domain.presenter.genre;

import source.controller.genres.crud.response.GenreResponseViewModel;
import source.domain.entity.db.Genres;

public interface IGenreMappingPresenter {
    GenreResponseViewModel mapping(Genres genre);
}
