package source.controller.genres.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import source.controller.genres.GenresController;
import source.usecases.app.genres.IGenreUpdateUsecase;
import source.usecases.dto.request.genre.GenreUpdateRequestData;
import source.usecases.dto.response.genre.GenreResponseViewModel;

@RestController
@RequiredArgsConstructor
public class GenreUpdateController extends GenresController {
    @Autowired
    private IGenreUpdateUsecase usecase;

    @PutMapping(value = "/{id}")
    public GenreResponseViewModel handle(
            @PathVariable("userId") Long userId,
            @PathVariable("id") Long id,
            @RequestBody GenreUpdateRequestData requestData
    ) {
        return this.usecase.update(userId, id, requestData);
    }
}
