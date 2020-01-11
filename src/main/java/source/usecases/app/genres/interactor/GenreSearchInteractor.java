package source.usecases.app.genres.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.domain.entity.Genres;
import source.domain.repository.db.GenresRepository;
import source.domain.repository.db.specification.GenreSpecification;
import source.usecases.app.genres.IGenreSearchUsecase;
import source.usecases.dto.response.genre.GenreResponseModel;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GenreSearchInteractor implements IGenreSearchUsecase {

    @Autowired
    private GenresRepository repository;

    @Override
    public List<GenreResponseModel> search(Long userId) {
        List<Genres> genres = this.repository.findAll(
                Specifications
                        .where(GenreSpecification.userIdEqual(userId))
        );

        return genres
                .stream()
                .map(
                        genre -> GenreResponseModel.of(
                                genre.getId(),
                                genre.getName(),
                                genre.getColor()
                        )
                )
                .collect(Collectors.toList());
    }
}
