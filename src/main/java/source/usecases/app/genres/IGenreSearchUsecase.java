package source.usecases.app.genres;

import source.usecases.dto.response.genre.GenreResponseViewModels;

public interface IGenreSearchUsecase {
    public GenreResponseViewModels search(Long userId);
}
