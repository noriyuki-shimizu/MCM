package source.presenter.genre;

import source.domain.entity.Genres;
import source.controller.genres.crud.response.GenreResponseViewModel;

public interface IGenreMappingPresenter {
    public GenreResponseViewModel mapping(Genres genre);
}
