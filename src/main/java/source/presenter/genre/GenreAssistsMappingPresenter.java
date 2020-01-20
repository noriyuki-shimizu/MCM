package source.presenter.genre;

import org.springframework.stereotype.Component;
import source.domain.entity.Genres;
import source.usecases.dto.response.genre.GenreAssistResponseModel;
import source.usecases.dto.response.genre.GenreAssistResponseViewModels;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GenreAssistsMappingPresenter implements IGenreAssistsMappingPresenter {
    @Override
    public GenreAssistResponseViewModels mapping(List<Genres> genres) {
        List<GenreAssistResponseModel> models = genres
                .stream()
                .map(genre -> GenreAssistResponseModel.of(
                        genre.getId(),
                        genre.getName(),
                        genre.getColor()
                ))
                .collect(Collectors.toList());

        return GenreAssistResponseViewModels.of(models);
    }
}
