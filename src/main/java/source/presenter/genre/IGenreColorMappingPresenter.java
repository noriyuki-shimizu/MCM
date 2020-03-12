package source.presenter.genre;

import source.controller.genres.assist.response.GenreColorResponseViewModels;

import java.util.List;

public interface IGenreColorMappingPresenter {
    GenreColorResponseViewModels mapping(List<String> canSelectedColors);
}
