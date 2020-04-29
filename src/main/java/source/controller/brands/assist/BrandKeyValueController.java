package source.controller.brands.assist;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import source.controller.brands.BrandsController;
import source.controller.brands.assist.response.BrandAssistResponseViewModels;
import source.usecases.app.IBrandCrudUsecase;

@RestController
@RequiredArgsConstructor
public class BrandKeyValueController extends BrandsController {
    @Autowired
    private IBrandCrudUsecase usecase;

    @GetMapping(value = "/keyValues")
    @ResponseStatus(HttpStatus.OK)
    public BrandAssistResponseViewModels handle(@PathVariable("userId") Long userId) {
        return this.usecase.acceptKeyValues(userId);
    }
}
