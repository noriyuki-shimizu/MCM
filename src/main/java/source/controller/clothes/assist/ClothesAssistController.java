package source.controller.clothes.assist;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import source.controller.clothes.ClothesController;
import source.usecases.app.clothes.IClothesCrudUsecase;
import source.controller.clothes.assist.response.ClothesAssistResponseViewModels;

@RestController
@RequiredArgsConstructor
public class ClothesAssistController extends ClothesController {
    @Autowired
    private IClothesCrudUsecase usecase;

    @GetMapping(value = "/items")
    @ResponseStatus(HttpStatus.OK)
    public ClothesAssistResponseViewModels handle(@PathVariable("userId") Long userId) {
        return this.usecase.acceptKeyValues(userId);
    }
}
