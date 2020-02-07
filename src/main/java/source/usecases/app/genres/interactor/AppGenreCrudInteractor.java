package source.usecases.app.genres.interactor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.domain.GenreColor;
import source.domain.entity.Clothes;
import source.domain.entity.Genres;
import source.domain.repository.db.ClothesRepository;
import source.domain.repository.db.GenresRepository;
import source.domain.repository.db.specification.ClothesSpecification;
import source.domain.repository.db.specification.GenreSpecification;
import source.presenter.genre.*;
import source.usecases.app.genres.IGenreCrudUsecase;
import source.usecases.dto.request.genre.GenreCreateRequestModel;
import source.usecases.dto.request.genre.GenreUpdateRequestModel;
import source.usecases.dto.response.genre.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Transactional
@Slf4j
public class AppGenreCrudInteractor implements IGenreCrudUsecase {
    @Autowired
    private GenresRepository repository;

    @Autowired
    private ClothesRepository clothesRepository;

    @Autowired
    private IGenreAssistsMappingPresenter genreAssistsMappingPresenter;

    @Autowired
    private IGenreMappingPresenter genreMappingPresenter;

    @Autowired
    private IGenresMappingPresenter genresMappingPresenter;

    @Autowired
    private ITotalPricePerGenrePresenter totalPricePerGenrePresenter;

    @Autowired
    private IGenreColorMappingPresenter genreColorMappingPresenter;

    @Override
    public GenreKeyValueResponseViewModels acceptKeyValues(Long userId) {
        List<Genres> genres = this.repository.findAll(
                Specifications
                        .where(GenreSpecification.userIdEqual(userId))
        );

        return this.genreAssistsMappingPresenter.mapping(genres);
    }

    @Override
    public GenreColorResponseViewModels acceptCanSelectedColors(Long userId, Long id) {
        List<Genres> genres = this.repository.findAll(
                Specifications
                        .where(GenreSpecification.userIdEqual(userId))
        );
        List<String> selectedColors = Optional.ofNullable(id)
                .map(i ->
                        genres
                            .stream()
                            .filter(genre -> genre.getId() != i)
                            .map(Genres::getColor)
                            .collect(Collectors.toList())
                )
                .orElse(
                        genres
                                .stream()
                                .map(Genres::getColor)
                                .collect(Collectors.toList())
                );

        return this.genreColorMappingPresenter.mapping(
                GenreColor.acceptCanSelectedColors(selectedColors)
        );
    }

    @Override
    public GenreResponseViewModel create(Long userId, GenreCreateRequestModel requestData) {
        Genres genres = Genres.builder()
                .userId(userId)
                .name(requestData.getName())
                .color(requestData.getColor())
                .build();

        Genres result = this.repository.save(genres);

        return this.genreMappingPresenter.mapping(result);
    }

    @Override
    public void delete(Long id) {
        List<Clothes> clothes = this.clothesRepository.findAll(
                Specifications
                        .where(ClothesSpecification.hasGenres(id))
        );
        if(clothes.size() > 0) {
            String errorMessage = "The brand cannot be deleted because it is used by other data.";
            log.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }

        this.repository.delete(
                Genres.builder()
                        .id(id)
                        .build()
        );
    }

    @Override
    public GenreResponseViewModels search(Long userId) {
        List<Genres> genres = this.repository.findAll(
                Specifications
                        .where(GenreSpecification.userIdEqual(userId))
        );

        return this.genresMappingPresenter.mapping(genres);
    }

    @Override
    public GenreResponseViewModel update(Long userId, Long id, GenreUpdateRequestModel requestData) {
        Genres genres = Genres.builder()
                .id(id)
                .userId(userId)
                .name(requestData.getName())
                .color(requestData.getColor())
                .build();

        Genres result = this.repository.save(genres);

        return this.genreMappingPresenter.mapping(result);
    }

    @Override
    public TotalPricePerGenreViewModels acceptTotalPricePerGenre(Long userId) {
        List<Genres> genres = this.repository.findAll(
                Specifications
                        .where(GenreSpecification.userIdEqual(userId))
        );
        return this.totalPricePerGenrePresenter.mapping(genres);
    }
}
