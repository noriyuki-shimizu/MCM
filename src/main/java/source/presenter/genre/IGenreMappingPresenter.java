package source.presenter.genre;

import source.domain.entity.Genres;
import source.usecases.dto.response.genre.GenreResponseViewModel;

public interface IGenreMappingPresenter {
    public GenreResponseViewModel mapping(Genres genre);
}
