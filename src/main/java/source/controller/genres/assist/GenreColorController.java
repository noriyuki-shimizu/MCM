package source.controller.genres.assist;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import source.controller.genres.GenresController;
import source.usecases.app.genres.IGenreCrudUsecase;
import source.usecases.dto.response.genre.GenreColorResponseViewModels;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class GenreColorController extends GenresController {
    @Autowired
    private IGenreCrudUsecase usecase;

    @GetMapping(value = "/colors")
    public GenreColorResponseViewModels handle(@PathVariable("userId") Long userId, @RequestParam("id") Optional<Long> id) {
        return this.usecase.acceptCanSelectedColors(userId, id);
    }
}
