package source.presenter.clothes;

import org.springframework.stereotype.Component;
import source.domain.entity.Clothes;
import source.usecases.converter.BuyDate;
import source.usecases.dto.response.brands.BrandAssistResponseModel;
import source.usecases.dto.response.clothes.ClothesResponseModel;
import source.usecases.dto.response.clothes.ClothesResponseViewModels;
import source.usecases.dto.response.genre.GenreAssistResponseModel;
import source.usecases.dto.response.shops.ShopAssistResponseModel;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ClothesListMappingPresenter implements IClothesListMappingPresenter {
    @Override
    public ClothesResponseViewModels mapping(List<Clothes> clothes) {
        List<ClothesResponseModel> models = clothes
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
                    Set<GenreAssistResponseModel> genreModels = c
                            .getGenres()
                            .stream()
                            .map(genre -> GenreAssistResponseModel.of(
                                    genre.getId(),
                                    genre.getName(),
                                    genre.getColor()
                            ))
                            .collect(Collectors.toSet());

                    return ClothesResponseModel.of(
                            c.getId(),
                            c.getImage() != null
                                    ? c.getImage().getId()
                                    : null,
                            c.getImage() != null
                                    ? c.getImage().getPath()
                                    : null,
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
}
