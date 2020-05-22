package source.controller.clothes.curd;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import source.controller.clothes.ClothesController;
import source.controller.clothes.curd.request.ClothesCreateRequestModel;
import source.controller.clothes.curd.request.ClothesUpdateRequestModel;
import source.controller.clothes.curd.response.ClothesResponseViewModel;
import source.controller.clothes.curd.response.ClothesResponseViewModels;
import source.usecases.IClothesCrudUsecase;

@RestController
@RequiredArgsConstructor
public class ClothesCrudController extends ClothesController {
    @Autowired
    private IClothesCrudUsecase usecase;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ClothesResponseViewModel handleCreate(@PathVariable("userId") Long userId, @RequestBody ClothesCreateRequestModel inputData) {
        return usecase.create(userId, inputData);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable("userId") Long userId, @PathVariable("id") Long id) {
        usecase.delete(userId, id);
    }

    @PutMapping(value = "/{id}/restoration")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleRestoration(@PathVariable("userId") Long userId, @PathVariable("id") Long id) {
        usecase.restoration(userId, id);
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
    ) {
        usecase.update(userId, id, inputData);
    }
}
