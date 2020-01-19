package source.usecases.app.genres.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.entity.Genres;
import source.domain.repository.db.GenresRepository;
import source.usecases.app.genres.IGenreUpdateUsecase;
import source.usecases.dto.request.genre.GenreUpdateRequestData;
import source.usecases.dto.response.genre.GenreResponseModel;

import javax.transaction.Transactional;

@Component
@Transactional
public class GenreUpdateInteractor implements IGenreUpdateUsecase {
    @Autowired
    private GenresRepository repository;

    @Override
    public GenreResponseModel update(Long userId, Long id, GenreUpdateRequestData requestData) {
        Genres genres = Genres.builder()
                .id(id)
                .userId(userId)
                .name(requestData.getName())
                .color(requestData.getColor())
                .build();

        Genres result = this.repository.save(genres);

        return GenreResponseModel.of(
                result.getId(),
                result.getName(),
                result.getColor()
        );
    }
}