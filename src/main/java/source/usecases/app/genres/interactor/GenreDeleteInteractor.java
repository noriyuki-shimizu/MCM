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
import source.usecases.app.genres.IGenreDeleteUsecase;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
@Slf4j
public class GenreDeleteInteractor implements IGenreDeleteUsecase {
    @Autowired
    private GenresRepository repository;

    @Autowired
    private ClothesRepository clothesRepository;

    @Override
    public void delete(Long id) {
        List<Clothes> clothes = this.clothesRepository.findAll(
                Specifications
                        .where(ClothesSpecification.genreIdEqual(id))
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
}
