package source.presenter.coordinates;

import org.springframework.stereotype.Component;
import source.domain.entity.Coordinates;
import source.usecases.converter.BuyDate;
import source.usecases.dto.response.clothes.ClothesAssistResponseModel;
import source.usecases.dto.response.coordinates.CoordinateResponseModel;
import source.usecases.dto.response.coordinates.CoordinateResponseViewModel;
import source.usecases.dto.response.genre.ClothesGenreResponseModel;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CoordinateMappingPresenter implements ICoordinateMappingPresenter {
    @Override
    public CoordinateResponseViewModel mapping(Coordinates coordinate) {
        Set<ClothesAssistResponseModel> usedCoordinates = coordinate
                .getUsedCoordinates()
                .stream()
                .map(clothes -> ClothesAssistResponseModel.of(
                        clothes.getId(),
                        clothes.getImage().getPath(),
                        clothes.getBrand().getName(),
                        clothes.getShop().getName(),
                        clothes.getGenres()
                                .stream()
                                .map(genre -> ClothesGenreResponseModel.of(genre.getName(), genre.getColor()))
                                .collect(Collectors.toSet()),
                        clothes.getPrice(),
                        BuyDate.toString(clothes.getBuyDate()),
                        clothes.getComment(),
                        clothes.getSatisfaction()
                ))
                .collect(Collectors.toSet());

        CoordinateResponseModel model = CoordinateResponseModel.of(
                coordinate.getId(),
                coordinate.getSeason(),
                coordinate.getImage() != null
                        ? coordinate.getImage().getId()
                        : null,
                coordinate.getImage() != null
                        ? coordinate.getImage().getPath()
                        : null,
                usedCoordinates
        );

        return CoordinateResponseViewModel.of(model);
    }
}
