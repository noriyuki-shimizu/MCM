package source.controller.coordinates.curd;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import source.controller.coordinates.CoordinatesController;
import source.usecases.app.coordinates.ICoordinateUpdateUsecase;
import source.usecases.dto.request.coordinates.CoordinateUpdateRequestModel;
import source.usecases.dto.response.coordinates.CoordinateResponseViewModel;

@RestController
@RequiredArgsConstructor
public class CoordinateUpdateController extends CoordinatesController {
    @Autowired
    private ICoordinateUpdateUsecase usecase;

    @PutMapping("/{id}")
    public CoordinateResponseViewModel updateHandler(
            @PathVariable("userId") Long userId,
            @PathVariable("id") Long id,
            @RequestBody CoordinateUpdateRequestModel inputData
    ) {
        return this.usecase.update(userId, id, inputData);
    }
}
