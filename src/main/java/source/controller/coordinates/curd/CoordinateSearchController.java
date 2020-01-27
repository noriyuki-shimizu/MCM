package source.controller.coordinates.curd;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import source.controller.coordinates.CoordinatesController;
import source.usecases.app.coordinates.ICoordinateSearchUsecase;
import source.usecases.dto.response.coordinates.CoordinateResponseViewModels;

@RestController
@RequiredArgsConstructor
public class CoordinateSearchController extends CoordinatesController {
    @Autowired
    private ICoordinateSearchUsecase usecase;

    @GetMapping()
    public CoordinateResponseViewModels search(@PathVariable("userId") Long userId) {
        return this.usecase.search(userId);
    }
}
