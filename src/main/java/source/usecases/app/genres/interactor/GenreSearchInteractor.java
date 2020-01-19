package source.usecases.app.genres.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.domain.entity.Genres;
import source.domain.repository.db.GenresRepository;
import source.domain.repository.db.specification.GenreSpecification;
import source.presenter.genre.IGenresMappingPresenter;
import source.usecases.app.genres.IGenreSearchUsecase;
import source.usecases.dto.response.genre.GenreResponseViewModels;

import java.util.List;

@Component
public class GenreSearchInteractor implements IGenreSearchUsecase {

    @Autowired
    private GenresRepository repository;

    @Autowired
    private IGenresMappingPresenter presenter;

    @Override
    public GenreResponseViewModels search(Long userId) {
        List<Genres> genres = this.repository.findAll(
                Specifications
                        .where(GenreSpecification.userIdEqual(userId))
        );

        return this.presenter.mapping(genres);
    }
}
