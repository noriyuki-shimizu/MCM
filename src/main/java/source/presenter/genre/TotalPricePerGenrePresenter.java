package source.presenter.genre;

import org.springframework.stereotype.Component;
import source.controller.genres.crud.response.TotalPricePerGenreModel;
import source.controller.genres.crud.response.TotalPricePerGenreViewModels;
import source.domain.entity.db.Clothes;
import source.domain.entity.db.Genres;
import source.domain.presenter.genre.ITotalPricePerGenrePresenter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TotalPricePerGenrePresenter implements ITotalPricePerGenrePresenter {
    @Override
    public TotalPricePerGenreViewModels mapping(List<Genres> genres) {
        List<TotalPricePerGenreModel> models = genres
                .stream()
                .filter(genre -> !genre.getClothes().isEmpty())
                .map(genre -> {
                    Optional<Integer> pricePerGenreOpt = genre
                            .getClothes()
                            .stream()
                            .map(Clothes::getPrice)
                            .reduce((accumulator, value) -> accumulator + value);

                    return  TotalPricePerGenreModel.of(
                                genre.getName(),
                                genre.getColor(),
                                pricePerGenreOpt.orElse(0)
                    );
                })
                .collect(Collectors.toList());

        return TotalPricePerGenreViewModels.of(models);
    }
}
