package source.presenter.genre;

import org.springframework.stereotype.Component;
import source.domain.entity.Clothes;
import source.domain.entity.Genres;
import source.usecases.dto.response.genre.TotalPricePerGenreModel;
import source.usecases.dto.response.genre.TotalPricePerGenreViewModels;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TotalPricePerGenrePresenter implements ITotalPricePerGenrePresenter {
    @Override
    public TotalPricePerGenreViewModels mapping(List<Genres> genres) {
        List<TotalPricePerGenreModel> models = genres
                .stream()
                .filter(genre -> !genre.getClothes().isEmpty())
                .map(genre -> {
                    Integer pricePerGenre = genre
                            .getClothes()
                            .stream()
                            .map(Clothes::getPrice)
                            .reduce((accumulator, value) -> accumulator + value)
                            .get();

                    return  TotalPricePerGenreModel.of(
                                genre.getName(),
                                genre.getColor(),
                                pricePerGenre
                    );
                })
                .collect(Collectors.toList());

        return TotalPricePerGenreViewModels.of(models);
    }
}
