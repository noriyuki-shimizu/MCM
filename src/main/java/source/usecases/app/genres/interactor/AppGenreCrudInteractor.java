package source.usecases.app.genres.interactor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.domain.entity.Clothes;
import source.domain.entity.Genres;
import source.domain.repository.db.ClothesRepository;
import source.domain.repository.db.GenresRepository;
import source.domain.repository.db.specification.ClothesSpecification;
import source.domain.repository.db.specification.GenreSpecification;
import source.domain.GenreColor;
import source.presenter.genre.IGenreAssistsMappingPresenter;
import source.presenter.genre.IGenreMappingPresenter;
import source.presenter.genre.IGenresMappingPresenter;
import source.presenter.genre.ITotalPricePerGenrePresenter;
import source.usecases.app.genres.IGenreCrudUsecase;
import source.usecases.dto.request.genre.GenreCreateRequestModel;
import source.usecases.dto.request.genre.GenreUpdateRequestModel;
import source.usecases.dto.response.genre.GenreAssistResponseViewModels;
import source.usecases.dto.response.genre.GenreResponseViewModel;
import source.usecases.dto.response.genre.GenreResponseViewModels;
import source.usecases.dto.response.genre.TotalPricePerGenreViewModels;

import javax.transaction.Transactional;
import java.util.List;

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

    @Override
    public GenreAssistResponseViewModels acceptKeyValues(Long userId) {
        List<Genres> genres = this.repository.findAll(
                Specifications
                        .where(GenreSpecification.userIdEqual(userId))
        );

        return this.genreAssistsMappingPresenter.mapping(genres);
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
