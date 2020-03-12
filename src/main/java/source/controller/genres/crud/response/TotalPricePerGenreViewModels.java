package source.controller.genres.crud.response;

import lombok.Value;

import java.util.List;

@Value(staticConstructor = "of")
public class TotalPricePerGenreViewModels {
    private List<TotalPricePerGenreModel> totalPricePerGenres;
}
