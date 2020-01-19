package source.usecases.app.genres;

import source.usecases.dto.request.genre.GenreCreateRequestData;
import source.usecases.dto.response.genre.GenreResponseViewModel;

public interface IGenreCreateUsecase {
    public GenreResponseViewModel create(Long userId, GenreCreateRequestData requestData);
}
