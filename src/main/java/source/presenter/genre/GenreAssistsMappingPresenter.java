package source.presenter.genre;

import org.springframework.stereotype.Component;
import source.domain.entity.Genres;
import source.controller.genres.assist.response.GenreKeyValueResponseModel;
import source.controller.genres.assist.response.GenreKeyValueResponseViewModels;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GenreAssistsMappingPresenter implements IGenreAssistsMappingPresenter {
    @Override
    public GenreKeyValueResponseViewModels mapping(List<Genres> genres) {
        List<GenreKeyValueResponseModel> models = genres
                .stream()
                .map(genre -> GenreKeyValueResponseModel.of(
                        genre.getId(),
                        genre.getName(),
                        genre.getColor()
                ))
                .collect(Collectors.toList());

        return GenreKeyValueResponseViewModels.of(models);
    }
}
