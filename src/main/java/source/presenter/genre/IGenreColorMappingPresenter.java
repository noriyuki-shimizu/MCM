package source.presenter.genre;

import source.usecases.dto.response.genre.GenreColorResponseViewModels;

import java.util.List;

public interface IGenreColorMappingPresenter {
    public GenreColorResponseViewModels mapping(List<String> canSelectedColors);
}
