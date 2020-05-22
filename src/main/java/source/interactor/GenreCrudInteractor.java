package source.interactor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.controller.genres.assist.response.GenreColorResponseViewModels;
import source.controller.genres.assist.response.GenreKeyValueResponseViewModels;
import source.controller.genres.crud.request.GenreCreateRequestModel;
import source.controller.genres.crud.request.GenreUpdateRequestModel;
import source.controller.genres.crud.response.GenreResponseViewModel;
import source.controller.genres.crud.response.GenreResponseViewModels;
import source.controller.genres.crud.response.TotalPricePerGenreViewModels;
import source.domain.GenreColor;
import source.domain.entity.db.Clothes;
import source.domain.entity.db.Genres;
import source.domain.logging.CrudLogging;
import source.domain.logging.LoggingHead;
import source.domain.presenter.IGenrePresenter;
import source.domain.repository.db.ClothesRepository;
import source.domain.repository.db.GenresRepository;
import source.domain.repository.db.specification.ClothesSpecification;
import source.usecases.IGenreCrudUsecase;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Transactional
@Slf4j
public class GenreCrudInteractor implements IGenreCrudUsecase {
    @Autowired
    private GenresRepository repository;

    @Autowired
    private ClothesRepository clothesRepository;

    @Autowired
    private IGenrePresenter presenter;

    @Override
    public GenreKeyValueResponseViewModels acceptKeyValues(final Long userId) {
        final List<Genres> genres = repository.findByUserIdOrderByName(userId);

        return presenter.toGenreKeyValueResponseViewModels(genres);
    }

    @Override
    public GenreColorResponseViewModels acceptCanSelectedColors(final Long userId, final Optional<Long> id) {
        final List<Genres> genres = repository.findByUserIdOrderByName(userId);

        final List<String> selectedColors = id
                .map(i ->
                        genres
                            .stream()
                            .filter(genre -> !genre.getId().equals(i))
                            .map(Genres::getColor)
                            .collect(Collectors.toList())
                )
                .orElse(
                        genres
                                .stream()
                                .map(Genres::getColor)
                                .collect(Collectors.toList())
                );

        return presenter.toGenreColorResponseViewModels(
                GenreColor.acceptCanSelectedColors(selectedColors)
        );
    }

    @Override
    public GenreResponseViewModel create(final Long userId, final GenreCreateRequestModel requestData) {
        final Genres genres = Genres.builder()
                .userId(userId)
                .name(requestData.getName())
                .color(requestData.getColor())
                .build();

        final Genres result = repository.save(genres);

        CrudLogging.logging(LoggingHead.GENRE_CREATE, userId, result);

        return presenter.toGenreResponseViewModel(result);
    }

    @Override
    public void delete(final Long userId, final Long id) {
        final List<Clothes> clothes = clothesRepository.findAll(
                Specifications
                        .where(ClothesSpecification.hasGenres(id))
        );
        if(clothes.size() > 0) {
            final String errorMessage = "The brand cannot be deleted because it is used by other data.";
            log.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }

        repository.delete(
                Genres.builder()
                        .id(id)
                        .build()
        );

        CrudLogging.logging(LoggingHead.GENRE_DELETE, userId, id);
    }

    @Override
    public GenreResponseViewModels search(final Long userId) {
        final List<Genres> genres = repository.findByUserIdOrderByName(userId);

        return presenter.toGenreResponseViewModels(genres);
    }

    @Override
    public GenreResponseViewModel searchById(final Long id) {
        final Genres genre = repository.findOne(id);
        return presenter.toGenreResponseViewModel(genre);
    }

    @Override
    public void update(final Long userId, final Long id, final GenreUpdateRequestModel requestData) {
        final Genres genres = Genres.builder()
                .id(id)
                .userId(userId)
                .name(requestData.getName())
                .color(requestData.getColor())
                .build();

        repository.save(genres);

        CrudLogging.logging(LoggingHead.GENRE_UPDATE, userId, genres);
    }

    @Override
    public TotalPricePerGenreViewModels acceptTotalPricePerGenre(final Long userId) {
        final List<Genres> genres = repository.findByUserIdOrderByName(userId);

        return presenter.toTotalPricePerGenreViewModels(genres);
    }
}
