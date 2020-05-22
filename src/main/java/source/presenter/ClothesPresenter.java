package source.presenter;

import org.springframework.stereotype.Component;
import source.controller.brands.assist.response.BrandAssistResponseModel;
import source.controller.clothes.assist.response.ClothesAssistResponseModel;
import source.controller.clothes.assist.response.ClothesAssistResponseViewModels;
import source.controller.clothes.assist.response.ClothesGenreResponseModel;
import source.controller.clothes.curd.response.ClothesResponseModel;
import source.controller.clothes.curd.response.ClothesResponseViewModel;
import source.controller.clothes.curd.response.ClothesResponseViewModels;
import source.controller.genres.assist.response.GenreKeyValueResponseModel;
import source.controller.shops.assist.response.ShopAssistResponseModel;
import source.domain.entity.db.Clothes;
import source.domain.presenter.IClothesPresenter;
import source.converter.BuyDate;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ClothesPresenter implements IClothesPresenter {
    @Override
    public ClothesAssistResponseViewModels toClothesAssistResponseViewModels(List<Clothes> clothes) {
        final List<ClothesAssistResponseModel> models = clothes
                .stream()
                .map(c -> {
                    Set<ClothesGenreResponseModel> genres = c.getGenres()
                            .stream()
                            .map(genre -> ClothesGenreResponseModel.of(genre.getName(), genre.getColor()))
                            .collect(Collectors.toSet());

                    return ClothesAssistResponseModel.of(
                            c.getId(),
                            c.getImage().getPath(),
                            c.getBrand().getName(),
                            c.getShop().getName(),
                            genres,
                            c.getPrice(),
                            BuyDate.toString(c.getBuyDate()),
                            c.getComment(),
                            c.getSatisfaction()
                    );
                })
                .collect(Collectors.toList());

        return ClothesAssistResponseViewModels.of(models);
    }

    @Override
    public ClothesResponseViewModels toClothesResponseViewModels(List<Clothes> clothes) {
        final List<ClothesResponseModel> models = clothes
                .stream()
                .map(c -> {
                    BrandAssistResponseModel brandModel = BrandAssistResponseModel.of(
                            c.getBrand().getId(),
                            c.getBrand().getName()
                    );
                    ShopAssistResponseModel shopModel = ShopAssistResponseModel.of(
                            c.getShop().getId(),
                            c.getShop().getName()
                    );
                    Set<GenreKeyValueResponseModel> genreModels = c
                            .getGenres()
                            .stream()
                            .map(genre -> GenreKeyValueResponseModel.of(
                                    genre.getId(),
                                    genre.getName(),
                                    genre.getColor()
                            ))
                            .collect(Collectors.toSet());

                    return ClothesResponseModel.of(
                            c.getId(),
                            c.getImage().getId(),
                            c.getImage().getPath(),
                            brandModel,
                            shopModel,
                            genreModels,
                            c.getPrice(),
                            BuyDate.toString(c.getBuyDate()),
                            c.getComment(),
                            c.getSatisfaction(),
                            c.isDeleted()
                    );
                })
                .collect(Collectors.toList());

        return ClothesResponseViewModels.of(models);
    }

    @Override
    public ClothesResponseViewModel toClothesResponseViewModel(Clothes clothes) {
        final BrandAssistResponseModel brandModel = BrandAssistResponseModel.of(
                clothes.getBrand().getId(),
                clothes.getBrand().getName()
        );
        final ShopAssistResponseModel shopModel = ShopAssistResponseModel.of(
                clothes.getShop().getId(),
                clothes.getShop().getName()
        );
        final Set<GenreKeyValueResponseModel> genreModels = clothes
                .getGenres()
                .stream()
                .map(genre -> GenreKeyValueResponseModel.of(
                        genre.getId(),
                        genre.getName(),
                        genre.getColor()
                ))
                .collect(Collectors.toSet());

        final ClothesResponseModel model = ClothesResponseModel.of(
                clothes.getId(),
                clothes.getImage().getId(),
                clothes.getImage().getPath(),
                brandModel,
                shopModel,
                genreModels,
                clothes.getPrice(),
                BuyDate.toString(clothes.getBuyDate()),
                clothes.getComment(),
                clothes.getSatisfaction(),
                clothes.isDeleted()
        );

        return ClothesResponseViewModel.of(model);
    }
}
