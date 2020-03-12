package source.presenter.coordinates;

import org.springframework.stereotype.Component;
import source.domain.entity.Coordinates;
import source.domain.entity.Images;
import source.usecases.converter.BuyDate;
import source.controller.clothes.assist.response.ClothesAssistResponseModel;
import source.controller.coordinates.curd.response.CoordinateResponseModel;
import source.controller.coordinates.curd.response.CoordinateResponseViewModel;
import source.controller.clothes.assist.response.ClothesGenreResponseModel;

import java.util.Optional;
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
                Optional
                        .ofNullable(coordinate.getImage())
                        .map(Images::getId)
                        .orElse(null),
                Optional
                        .ofNullable(coordinate.getImage())
                        .map(Images::getPath)
                        .orElse(null),
                usedCoordinates
        );

        return CoordinateResponseViewModel.of(model);
    }
}
