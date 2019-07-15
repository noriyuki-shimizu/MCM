package source.controller.brands.crud;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import source.controller.brands.BrandsController;
import source.domain.dto.input.brands.BrandUpdateInputData;
import source.usecases.brands.IBrandUpdateUsecase;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class BrandsUpdateController extends BrandsController {

    @Autowired
    private IBrandUpdateUsecase usecase;

    @PutMapping(value = "/")
    public String updateHandler(@PathVariable("userId") Long userId, @RequestParam("inputDataJson") String inputDataJson) {
        try {
            BrandUpdateInputData inputData = super.MAPPER.readValue(inputDataJson, BrandUpdateInputData.class);

            return super.MAPPER.writeValueAsString(this.usecase.update(userId, inputData));
        } catch (JsonProcessingException jpe) {
            jpe.printStackTrace();

            return null;
        } catch (IOException ioe) {
            ioe.printStackTrace();

            return null;
        }
    }
}
