package source.controller.coordinates.curd;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import source.controller.coordinates.CoordinatesController;
import source.usecases.app.coordinates.ICoordinateCreateUsecase;
import source.usecases.dto.request.coordinates.CoordinateCreateRequestModel;
import source.usecases.dto.response.coordinates.CoordinateResponseViewModel;

@RestController
@RequiredArgsConstructor
public class CoordinateCreateController extends CoordinatesController {
    @Autowired
    private ICoordinateCreateUsecase usecase;

    @PostMapping()
    public CoordinateResponseViewModel createHandler(@PathVariable("userId") Long userId, @RequestBody CoordinateCreateRequestModel inputData) {
        return this.usecase.create(userId, inputData);
    }
}
