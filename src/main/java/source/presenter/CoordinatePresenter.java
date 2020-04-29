package source.presenter;

import org.springframework.stereotype.Component;
import source.controller.clothes.assist.response.ClothesAssistResponseModel;
import source.controller.clothes.assist.response.ClothesGenreResponseModel;
import source.controller.coordinates.curd.response.CoordinateResponseModel;
import source.controller.coordinates.curd.response.CoordinateResponseViewModel;
import source.controller.coordinates.curd.response.CoordinateResponseViewModels;
import source.domain.entity.db.Coordinates;
import source.domain.entity.db.Images;
import source.domain.presenter.ICoordinatePresenter;
import source.usecases.converter.BuyDate;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CoordinatePresenter implements ICoordinatePresenter {
    @Override
    public CoordinateResponseViewModel toCoordinateResponseViewModel(Coordinates coordinate) {
        final Set<ClothesAssistResponseModel> usedCoordinates = coordinate
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

        final CoordinateResponseModel model = CoordinateResponseModel.of(
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

    @Override
    public CoordinateResponseViewModels toCoordinateResponseViewModels(List<Coordinates> coordinates) {
        final List<CoordinateResponseModel> models = coordinates
                .stream()
                .map(coordinate -> {
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

                    return CoordinateResponseModel.of(
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
                })
                .collect(Collectors.toList());

        return CoordinateResponseViewModels.of(models);
    }
}
