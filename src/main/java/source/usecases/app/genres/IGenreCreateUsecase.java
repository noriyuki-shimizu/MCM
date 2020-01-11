package source.usecases.app.genres;

import source.usecases.dto.request.genre.GenreCreateRequestData;
import source.usecases.dto.response.genre.GenreResponseModel;

public interface IGenreCreateUsecase {
    public GenreResponseModel create(Long userId, GenreCreateRequestData requestData);
}
