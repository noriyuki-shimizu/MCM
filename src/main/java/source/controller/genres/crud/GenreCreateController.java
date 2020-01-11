package source.controller.genres.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import source.controller.genres.GenresController;
import source.usecases.app.genres.IGenreCreateUsecase;
import source.usecases.dto.request.genre.GenreCreateRequestData;
import source.usecases.dto.response.genre.GenreResponseViewModel;

@RestController
@RequiredArgsConstructor
public class GenreCreateController extends GenresController {
    @Autowired
    private IGenreCreateUsecase usecase;

    @PostMapping
    public GenreResponseViewModel handle(
            @PathVariable("userId") Long userId,
            @RequestBody GenreCreateRequestData requestData
    ) {
        return GenreResponseViewModel.of(
                this.usecase.create(userId, requestData)
        );
    }
}
