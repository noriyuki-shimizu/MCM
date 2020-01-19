package source.usecases.app.genres;

import source.usecases.dto.request.genre.GenreUpdateRequestData;
import source.usecases.dto.response.genre.GenreResponseViewModel;

public interface IGenreUpdateUsecase {
    public GenreResponseViewModel update(Long userId, Long id, GenreUpdateRequestData requestData);
}
