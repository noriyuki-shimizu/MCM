package source.controller.coordinates.curd;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import source.controller.coordinates.CoordinatesController;
import source.usecases.app.coordinates.ICoordinateCrudUsecase;
import source.usecases.dto.request.coordinates.CoordinateCreateRequestModel;
import source.usecases.dto.request.coordinates.CoordinateUpdateRequestModel;
import source.usecases.dto.response.coordinates.CoordinateResponseViewModel;
import source.usecases.dto.response.coordinates.CoordinateResponseViewModels;

@RestController
@RequiredArgsConstructor
public class CoordinateCrudController extends CoordinatesController {
    @Autowired
    private ICoordinateCrudUsecase usecase;

    @PostMapping()
    public CoordinateResponseViewModel handleCreate(@PathVariable("userId") Long userId, @RequestBody CoordinateCreateRequestModel inputData) {
        return this.usecase.create(userId, inputData);
    }

    @DeleteMapping(value = "/{id}")
    public void handleDelete(@PathVariable("id") Long id) {
        this.usecase.delete(id);
    }

    @GetMapping()
    public CoordinateResponseViewModels handleSearch(@PathVariable("userId") Long userId) {
        return this.usecase.search(userId);
    }

    @GetMapping(value = "/{id}")
    public CoordinateResponseViewModel handleSearchById(@PathVariable("id") Long id) {
        return this.usecase.searchById(id);
    }

    @PutMapping("/{id}")
    public CoordinateResponseViewModel handleUpdate(
            @PathVariable("userId") Long userId,
            @PathVariable("id") Long id,
            @RequestBody CoordinateUpdateRequestModel inputData
    ) {
        return this.usecase.update(userId, id, inputData);
    }
}
