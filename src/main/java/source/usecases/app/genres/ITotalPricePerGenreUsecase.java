package source.usecases.app.genres;

import source.usecases.dto.response.genre.TotalPricePerGenreViewModels;

public interface ITotalPricePerGenreUsecase {
    public TotalPricePerGenreViewModels get(Long userId);
}
