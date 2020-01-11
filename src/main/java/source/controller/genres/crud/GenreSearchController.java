package source.controller.genres.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import source.controller.genres.GenresController;
import source.usecases.app.genres.IGenreSearchUsecase;
import source.usecases.dto.response.genre.GenreResponseViewModels;

@RestController
@RequiredArgsConstructor
public class GenreSearchController extends GenresController {
    @Autowired
    private IGenreSearchUsecase usecase;

    @GetMapping
    public GenreResponseViewModels handle(
            @PathVariable("userId") Long userId
    ) {
        return GenreResponseViewModels.of(
                this.usecase.search(userId)
        );
    }
}
