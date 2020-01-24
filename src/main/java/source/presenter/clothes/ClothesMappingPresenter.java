package source.presenter.clothes;

import org.springframework.stereotype.Component;
import source.domain.entity.Clothes;
import source.usecases.converter.BuyDate;
import source.usecases.dto.response.brands.BrandAssistResponseModel;
import source.usecases.dto.response.clothes.ClothesResponseModel;
import source.usecases.dto.response.clothes.ClothesResponseViewModel;
import source.usecases.dto.response.genre.GenreAssistResponseModel;
import source.usecases.dto.response.shops.ShopAssistResponseModel;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ClothesMappingPresenter implements IClothesMappingPresenter {
    @Override
    public ClothesResponseViewModel mapping(Clothes clothes) {
        BrandAssistResponseModel brandModel = BrandAssistResponseModel.of(
                clothes.getBrand().getId(),
                clothes.getBrand().getName()
        );
        ShopAssistResponseModel shopModel = ShopAssistResponseModel.of(
                clothes.getShop().getId(),
                clothes.getShop().getName()
        );
        Set<GenreAssistResponseModel> genreModels = clothes
                .getGenres()
                .stream()
                .map(genre -> GenreAssistResponseModel.of(
                        genre.getId(),
                        genre.getName(),
                        genre.getColor()
                ))
                .collect(Collectors.toSet());

        ClothesResponseModel model = ClothesResponseModel.of(
                clothes.getId(),
                clothes.getImage() != null
                        ? clothes.getImage().getId()
                        : null,
                clothes.getImage() != null
                        ? clothes.getImage().getPath()
                        : null,
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
