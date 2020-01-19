package source.usecases.app.genres.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.entity.Genres;
import source.domain.repository.db.GenresRepository;
import source.presenter.genre.IGenreMappingPresenter;
import source.usecases.app.genres.IGenreCreateUsecase;
import source.usecases.dto.request.genre.GenreCreateRequestData;
import source.usecases.dto.response.genre.GenreResponseViewModel;

import javax.transaction.Transactional;

@Component
@Transactional
public class GenreCreateInteractor implements IGenreCreateUsecase {
    @Autowired
    private GenresRepository repository;

    @Autowired
    private IGenreMappingPresenter presenter;

    @Override
    public GenreResponseViewModel create(Long userId, GenreCreateRequestData requestData) {
        Genres genres = Genres.builder()
                .userId(userId)
                .name(requestData.getName())
                .color(requestData.getColor())
                .build();

        Genres result = this.repository.save(genres);

        return this.presenter.mapping(result);
    }
}
