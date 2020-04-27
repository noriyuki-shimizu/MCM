package source.presenter.clothes;

import org.springframework.stereotype.Component;
import source.controller.brands.assist.response.BrandAssistResponseModel;
import source.controller.clothes.curd.response.ClothesResponseModel;
import source.controller.clothes.curd.response.ClothesResponseViewModel;
import source.controller.genres.assist.response.GenreKeyValueResponseModel;
import source.controller.shops.assist.response.ShopAssistResponseModel;
import source.domain.entity.db.Clothes;
import source.domain.presenter.clothes.IClothesMappingPresenter;
import source.usecases.converter.BuyDate;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ClothesMappingPresenter implements IClothesMappingPresenter {
    @Override
    public ClothesResponseViewModel mapping(final Clothes clothes) {
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
