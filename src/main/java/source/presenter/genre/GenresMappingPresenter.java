package source.presenter.genre;

import org.springframework.stereotype.Component;
import source.controller.genres.crud.response.GenreResponseModel;
import source.controller.genres.crud.response.GenreResponseViewModels;
import source.domain.entity.db.Genres;
import source.domain.presenter.genre.IGenresMappingPresenter;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GenresMappingPresenter implements IGenresMappingPresenter {
    @Override
    public GenreResponseViewModels mapping(final List<Genres> genres) {
        final List<GenreResponseModel> models = genres
                .stream()
                .map(
                        genre -> GenreResponseModel.of(
                                genre.getId(),
                                genre.getName(),
                                genre.getColor()
                        )
                )
                .collect(Collectors.toList());

        return GenreResponseViewModels.of(models);
    }
}
