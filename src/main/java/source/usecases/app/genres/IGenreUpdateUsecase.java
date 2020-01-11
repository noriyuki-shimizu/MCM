package source.usecases.app.genres;

import source.usecases.dto.request.genre.GenreUpdateRequestData;
import source.usecases.dto.response.genre.GenreResponseModel;

public interface IGenreUpdateUsecase {
    public GenreResponseModel update(Long userId, Long id, GenreUpdateRequestData requestData);
}
