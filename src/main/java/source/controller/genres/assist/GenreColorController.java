package source.controller.genres.assist;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import source.controller.genres.GenresController;
import source.usecases.app.IGenreCrudUsecase;
import source.controller.genres.assist.response.GenreColorResponseViewModels;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class GenreColorController extends GenresController {
    @Autowired
    private IGenreCrudUsecase usecase;

    @GetMapping(value = "/colors")
    @ResponseStatus(HttpStatus.OK)
    public GenreColorResponseViewModels handle(@PathVariable("userId") Long userId, @RequestParam("id") Optional<Long> id) {
        return this.usecase.acceptCanSelectedColors(userId, id);
    }
}
