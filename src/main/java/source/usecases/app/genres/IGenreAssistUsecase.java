package source.usecases.app.genres;

import source.usecases.dto.response.genre.GenreAssistResponseViewModels;

public interface IGenreAssistUsecase {
    public GenreAssistResponseViewModels assist(Long userId);
}
