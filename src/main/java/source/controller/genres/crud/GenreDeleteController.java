package source.controller.genres.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import source.controller.genres.GenresController;
import source.usecases.app.genres.IGenreDeleteUsecase;

@RestController
@RequiredArgsConstructor
public class GenreDeleteController extends GenresController {
    @Autowired
    private IGenreDeleteUsecase usecase;

    @DeleteMapping(value = "/{id}")
    public void handle(@PathVariable("id") Long id) {
        this.usecase.delete(id);
    }
}
