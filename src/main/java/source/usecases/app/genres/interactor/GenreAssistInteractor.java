package source.usecases.app.genres.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.domain.entity.Genres;
import source.domain.repository.db.GenresRepository;
import source.domain.repository.db.specification.GenreSpecification;
import source.presenter.genre.IGenreAssistsMappingPresenter;
import source.usecases.app.genres.IGenreAssistUsecase;
import source.usecases.dto.response.genre.GenreAssistResponseViewModels;

import java.util.List;

@Component
public class GenreAssistInteractor implements IGenreAssistUsecase {
    @Autowired
    private GenresRepository repository;

    @Autowired
    private IGenreAssistsMappingPresenter presenter;

    @Override
    public GenreAssistResponseViewModels assist(Long userId) {
        List<Genres> genres = this.repository.findAll(
                Specifications
                        .where(GenreSpecification.userIdEqual(userId))
        );

        return this.presenter.mapping(genres);
    }
}
