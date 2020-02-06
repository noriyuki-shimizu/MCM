package source.controller.clothes.curd;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import source.controller.clothes.ClothesController;
import source.usecases.app.clothes.IClothesCrudUsecase;
import source.usecases.dto.request.clothes.ClothesCreateRequestModel;
import source.usecases.dto.request.clothes.ClothesUpdateRequestModel;
import source.usecases.dto.response.clothes.ClothesResponseViewModel;
import source.usecases.dto.response.clothes.ClothesResponseViewModels;

@RestController
@RequiredArgsConstructor
public class ClothesCrudController extends ClothesController {
    @Autowired
    private IClothesCrudUsecase usecase;

    @PostMapping()
    public ClothesResponseViewModel createHandler(@PathVariable("userId") Long userId, @RequestBody ClothesCreateRequestModel inputData) {
        return this.usecase.create(userId, inputData);
    }

    @DeleteMapping(value = "/{id}")
    public ClothesResponseViewModel deleteHandler(@PathVariable("id") Long id) {
        return this.usecase.delete(id);
    }

    @PutMapping(value = "/{id}/restoration")
    public ClothesResponseViewModel handle(@PathVariable("id") Long id) {
        return this.usecase.restoration(id);
    }

    @GetMapping()
    public ClothesResponseViewModels search(@PathVariable("userId") Long userId) {
        return this.usecase.search(userId);
    }

    @PutMapping("/{id}")
    public ClothesResponseViewModel updateHandler(
            @PathVariable("userId") Long userId,
            @PathVariable("id") Long id,
            @RequestBody ClothesUpdateRequestModel inputData
    ) {
        return this.usecase.update(userId, id, inputData);
    }
}
