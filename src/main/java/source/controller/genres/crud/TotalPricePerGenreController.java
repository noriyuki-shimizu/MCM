package source.controller.genres.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import source.controller.genres.GenresController;
import source.usecases.app.genres.ITotalPricePerGenreUsecase;
import source.usecases.dto.response.genre.TotalPricePerGenreViewModels;

@RestController
@RequiredArgsConstructor
public class TotalPricePerGenreController extends GenresController {
    @Autowired
    private ITotalPricePerGenreUsecase usecase;

    @GetMapping("/clothes/total-price")
    public TotalPricePerGenreViewModels get(@PathVariable("userId") Long userId) {
        return this.usecase.get(userId);
    }
}
