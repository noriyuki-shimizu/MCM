package source.usecases.app.genres.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.domain.entity.Genres;
import source.domain.repository.db.GenresRepository;
import source.domain.repository.db.specification.GenreSpecification;
import source.presenter.genre.ITotalPricePerGenrePresenter;
import source.usecases.app.genres.ITotalPricePerGenreUsecase;
import source.usecases.dto.response.genre.TotalPricePerGenreViewModels;

import java.util.List;

@Component
public class TotalPricePerGenreInteractor implements ITotalPricePerGenreUsecase {
    @Autowired
    private GenresRepository repository;

    @Autowired
    private ITotalPricePerGenrePresenter presenter;

    @Override
    public TotalPricePerGenreViewModels get(Long userId) {
        List<Genres> genres = this.repository.findAll(
                Specifications
                    .where(GenreSpecification.userIdEqual(userId))
        );
        return this.presenter.mapping(genres);
    }
}
