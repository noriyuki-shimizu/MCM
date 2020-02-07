package source.controller.genres.assist;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import source.controller.genres.GenresController;
import source.usecases.app.genres.IGenreCrudUsecase;
import source.usecases.dto.response.genre.GenreAssistResponseViewModels;

@RestController
@RequiredArgsConstructor
public class GenreKeyValueController extends GenresController {
    @Autowired
    private IGenreCrudUsecase usecase;

    @GetMapping(value = "/keyValues")
    public GenreAssistResponseViewModels handle(@PathVariable("userId") Long userId) {
        return this.usecase.acceptKeyValues(userId);
    }
}
