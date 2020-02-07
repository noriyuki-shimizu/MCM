package source.controller.genres.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import source.controller.genres.GenresController;
import source.usecases.app.genres.IGenreCrudUsecase;
import source.usecases.dto.request.genre.GenreCreateRequestModel;
import source.usecases.dto.request.genre.GenreUpdateRequestModel;
import source.usecases.dto.response.genre.GenreResponseViewModel;
import source.usecases.dto.response.genre.GenreResponseViewModels;
import source.usecases.dto.response.genre.TotalPricePerGenreViewModels;

@RestController
@RequiredArgsConstructor
public class GenreCrudController extends GenresController {
    @Autowired
    private IGenreCrudUsecase usecase;

    @PostMapping
    public GenreResponseViewModel createHandle(
            @PathVariable("userId") Long userId,
            @RequestBody GenreCreateRequestModel requestData
    ) {
        return this.usecase.create(userId, requestData);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteHandle(@PathVariable("id") Long id) {
        this.usecase.delete(id);
    }

    @GetMapping
    public GenreResponseViewModels SearchHandle(@PathVariable("userId") Long userId) {
        return this.usecase.search(userId);
    }

    @PutMapping(value = "/{id}")
    public GenreResponseViewModel updateHandle(
            @PathVariable("userId") Long userId,
            @PathVariable("id") Long id,
            @RequestBody GenreUpdateRequestModel requestData
    ) {
        return this.usecase.update(userId, id, requestData);
    }

    @GetMapping("/clothes/total-price")
    public TotalPricePerGenreViewModels totalPricePerGenreHandle(@PathVariable("userId") Long userId) {
        return this.usecase.acceptTotalPricePerGenre(userId);
    }
}
