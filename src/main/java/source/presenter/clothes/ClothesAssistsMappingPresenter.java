package source.presenter.clothes;

import org.springframework.stereotype.Component;
import source.controller.clothes.assist.response.ClothesAssistResponseModel;
import source.controller.clothes.assist.response.ClothesAssistResponseViewModels;
import source.controller.clothes.assist.response.ClothesGenreResponseModel;
import source.domain.entity.db.Clothes;
import source.domain.presenter.clothes.IClothesAssistsMappingPresenter;
import source.usecases.converter.BuyDate;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ClothesAssistsMappingPresenter implements IClothesAssistsMappingPresenter {
    @Override
    public ClothesAssistResponseViewModels mapping(final List<Clothes> clothes) {
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
}
