package source.controller.coordinates.curd;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import source.controller.coordinates.CoordinatesController;
import source.usecases.app.coordinates.ICoordinateCrudUsecase;
import source.controller.coordinates.curd.request.CoordinateCreateRequestModel;
import source.controller.coordinates.curd.request.CoordinateUpdateRequestModel;
import source.controller.coordinates.curd.response.CoordinateResponseViewModel;
import source.controller.coordinates.curd.response.CoordinateResponseViewModels;

@Slf4j(topic = "source.controller.coordinates.crud")
@RestController
@RequiredArgsConstructor
public class CoordinateCrudController extends CoordinatesController {
    @Autowired
    private ICoordinateCrudUsecase usecase;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CoordinateResponseViewModel handleCreate(@PathVariable("userId") Long userId, @RequestBody CoordinateCreateRequestModel inputData) throws JsonProcessingException {
        log.info("create -> user: {}, data: {}", userId, MAPPER.writeValueAsString(inputData));
        return this.usecase.create(userId, inputData);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable("userId") Long userId, @PathVariable("id") Long id) {
        log.info("delete -> user: {}, id: {}", userId, id);
        this.usecase.delete(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public CoordinateResponseViewModels handleSearch(@PathVariable("userId") Long userId) {
        return this.usecase.search(userId);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CoordinateResponseViewModel handleSearchById(@PathVariable("id") Long id) {
        return this.usecase.searchById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(
            @PathVariable("userId") Long userId,
            @PathVariable("id") Long id,
            @RequestBody CoordinateUpdateRequestModel inputData
    ) throws JsonProcessingException {
        log.info("update -> user: {}, id: {}, data: {}", userId, id, MAPPER.writeValueAsString(inputData));
        this.usecase.update(userId, id, inputData);
    }
}
