package source.controller.clothes.curd;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import source.controller.clothes.ClothesController;
import source.controller.clothes.curd.request.ClothesCreateRequestModel;
import source.controller.clothes.curd.request.ClothesUpdateRequestModel;
import source.controller.clothes.curd.response.ClothesResponseViewModel;
import source.controller.clothes.curd.response.ClothesResponseViewModels;
import source.usecases.app.IClothesCrudUsecase;

@Slf4j(topic = "source.controller.clothes.crud")
@RestController
@RequiredArgsConstructor
public class ClothesCrudController extends ClothesController {
    @Autowired
    private IClothesCrudUsecase usecase;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ClothesResponseViewModel handleCreate(@PathVariable("userId") Long userId, @RequestBody ClothesCreateRequestModel inputData) throws JsonProcessingException {
        log.info("create -> user: {}, data: {}", userId, MAPPER.writeValueAsString(inputData));
        return usecase.create(userId, inputData);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable("userId") Long userId, @PathVariable("id") Long id) {
        log.info("delete -> user: {}, id: {}", userId, id);
        usecase.delete(id);
    }

    @PutMapping(value = "/{id}/restoration")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleRestoration(@PathVariable("userId") Long userId, @PathVariable("id") Long id) {
        log.info("restoration -> user: {}, id: {}", userId, id);
        usecase.restoration(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ClothesResponseViewModels handleSearch(@PathVariable("userId") Long userId) {
        return usecase.search(userId);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClothesResponseViewModel handleSearchById(@PathVariable("id") Long id) {
        return usecase.searchById(id);
    }

    @GetMapping(value = "/total-price")
    @ResponseStatus(HttpStatus.OK)
    public long handleTotalPrice(@PathVariable("userId") Long userId) {
        return usecase.getTotalPriceByUserId(userId);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(
            @PathVariable("userId") Long userId,
            @PathVariable("id") Long id,
            @RequestBody ClothesUpdateRequestModel inputData
    ) throws JsonProcessingException {
        log.info("update -> user: {}, id: {}, data: {}", userId, id, MAPPER.writeValueAsString(inputData));
        usecase.update(userId, id, inputData);
    }
}
