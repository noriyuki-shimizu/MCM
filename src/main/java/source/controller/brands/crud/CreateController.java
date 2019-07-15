package source.controller.brands.crud;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import source.controller.brands.BrandsController;
import source.domain.dto.input.brands.BrandCreateInputData;
import source.usecases.brands.IBrandCreateUsecase;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class CreateController extends BrandsController {

    @Autowired
    private IBrandCreateUsecase usecase;

    @PostMapping(value = "/")
    public String createHandler(@PathVariable("userId") Long userId, @RequestParam("inputDataJson") String inputDataJson) {
        try {
            BrandCreateInputData inputData = super.MAPPER.readValue(inputDataJson, BrandCreateInputData.class);

            return super.MAPPER.writeValueAsString(this.usecase.create(userId, inputData));
        } catch (JsonProcessingException jpe) {
            jpe.printStackTrace();

            return null;
        } catch (IOException ioe) {
            ioe.printStackTrace();

            return null;
        }
    }
}
