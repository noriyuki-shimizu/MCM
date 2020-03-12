package source.controller.genres.assist;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import source.controller.genres.GenresController;
import source.usecases.app.genres.IGenreCrudUsecase;
import source.controller.genres.assist.response.GenreKeyValueResponseViewModels;

@RestController
@RequiredArgsConstructor
public class GenreKeyValueController extends GenresController {
    @Autowired
    private IGenreCrudUsecase usecase;

    @GetMapping(value = "/keyValues")
    @ResponseStatus(HttpStatus.OK)
    public GenreKeyValueResponseViewModels handle(@PathVariable("userId") Long userId) {
        return this.usecase.acceptKeyValues(userId);
    }
}
