package source.controller.brands.assist;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import source.controller.brands.BrandsController;
import source.usecases.app.brands.IBrandAssistUsecase;
import source.usecases.dto.response.brands.BrandAssistResponseViewModels;

@RestController
@RequiredArgsConstructor
public class BrandKeyValueController extends BrandsController {
    @Autowired
    private IBrandAssistUsecase usecase;

    @GetMapping(value = "/keyValues")
    public BrandAssistResponseViewModels handle(@PathVariable("userId") Long userId) {
        return this.usecase.assist(userId);
    }
}