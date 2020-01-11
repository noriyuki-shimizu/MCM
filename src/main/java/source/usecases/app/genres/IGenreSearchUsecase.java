package source.usecases.app.genres;

import source.usecases.dto.response.genre.GenreResponseModel;

import java.util.List;

public interface IGenreSearchUsecase {
    public List<GenreResponseModel> search(Long userId);
}
