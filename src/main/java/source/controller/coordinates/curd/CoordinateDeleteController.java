package source.controller.coordinates.curd;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import source.controller.coordinates.CoordinatesController;
import source.usecases.app.coordinates.ICoordinateDeleteUsecase;

@RestController
@RequiredArgsConstructor
public class CoordinateDeleteController extends CoordinatesController {
    @Autowired
    private ICoordinateDeleteUsecase usecase;

    @DeleteMapping(value = "/{id}")
    public void handle(@PathVariable("id") Long id) {
        this.usecase.delete(id);
    }
}
