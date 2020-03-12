package source.presenter.genre;

import org.springframework.stereotype.Component;
import source.domain.entity.Genres;
import source.controller.genres.crud.response.GenreResponseModel;
import source.controller.genres.crud.response.GenreResponseViewModels;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GenresMappingPresenter implements IGenresMappingPresenter {
    @Override
    public GenreResponseViewModels mapping(List<Genres> genres) {
        List<GenreResponseModel> models = genres
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
