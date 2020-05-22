package source.controller.coordinates.curd;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import source.controller.coordinates.CoordinatesController;
import source.controller.coordinates.curd.request.CoordinateCreateRequestModel;
import source.controller.coordinates.curd.request.CoordinateUpdateRequestModel;
import source.controller.coordinates.curd.response.CoordinateResponseViewModel;
import source.controller.coordinates.curd.response.CoordinateResponseViewModels;
import source.usecases.ICoordinateCrudUsecase;

@RestController
@RequiredArgsConstructor
public class CoordinateCrudController extends CoordinatesController {
    @Autowired
    private ICoordinateCrudUsecase usecase;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CoordinateResponseViewModel handleCreate(@PathVariable("userId") Long userId, @RequestBody CoordinateCreateRequestModel inputData) {
        return usecase.create(userId, inputData);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable("userId") Long userId, @PathVariable("id") Long id) {
        usecase.delete(userId, id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public CoordinateResponseViewModels handleSearch(@PathVariable("userId") Long userId) {
        return usecase.search(userId);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CoordinateResponseViewModel handleSearchById(@PathVariable("id") Long id) {
        return usecase.searchById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(
            @PathVariable("userId") Long userId,
            @PathVariable("id") Long id,
            @RequestBody CoordinateUpdateRequestModel inputData
    ) {
        usecase.update(userId, id, inputData);
    }
}
