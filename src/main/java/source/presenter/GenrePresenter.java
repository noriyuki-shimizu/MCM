package source.presenter;

import org.springframework.stereotype.Component;
import source.controller.genres.assist.response.GenreColorResponseViewModels;
import source.controller.genres.assist.response.GenreKeyValueResponseModel;
import source.controller.genres.assist.response.GenreKeyValueResponseViewModels;
import source.controller.genres.crud.response.*;
import source.domain.entity.db.Clothes;
import source.domain.entity.db.Genres;
import source.domain.presenter.IGenrePresenter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class GenrePresenter implements IGenrePresenter {
    @Override
    public GenreKeyValueResponseViewModels toGenreKeyValueResponseViewModels(List<Genres> genres) {
        final List<GenreKeyValueResponseModel> models = genres
                .stream()
                .map(genre -> GenreKeyValueResponseModel.of(
                        genre.getId(),
                        genre.getName(),
                        genre.getColor()
                ))
                .collect(Collectors.toList());

        return GenreKeyValueResponseViewModels.of(models);
    }

    @Override
    public GenreColorResponseViewModels toGenreColorResponseViewModels(List<String> canSelectedColors) {
        return GenreColorResponseViewModels.of(canSelectedColors);
    }

    @Override
    public GenreResponseViewModel toGenreResponseViewModel(Genres genre) {
        final GenreResponseModel model = GenreResponseModel.of(
                genre.getId(),
                genre.getName(),
                genre.getColor()
        );
        return GenreResponseViewModel.of(model);
    }

    @Override
    public GenreResponseViewModels toGenreResponseViewModels(List<Genres> genres) {
        final List<GenreResponseModel> models = genres
                .stream()
                .map(
                        genre -> GenreResponseModel.of(
                                genre.getId(),
                                genre.getName(),
                                genre.getColor()
                        )
                )
                .collect(Collectors.toList());

        return GenreResponseViewModels.of(models);
    }

    @Override
    public TotalPricePerGenreViewModels toTotalPricePerGenreViewModels(List<Genres> genres) {
        final List<TotalPricePerGenreModel> models = genres
                .stream()
                .filter(genre -> !genre.getClothes().isEmpty())
                .map(genre -> {
                    Optional<Integer> pricePerGenreOpt = genre
                            .getClothes()
                            .stream()
                            .map(Clothes::getPrice)
                            .reduce(Integer::sum);

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
