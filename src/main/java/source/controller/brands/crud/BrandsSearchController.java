package source.controller.brands.crud;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import source.controller.brands.BrandsController;
import source.domain.dto.input.brands.BrandSearchInputData;
import source.usecases.brands.IBrandSearchUsecase;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class BrandsSearchController extends BrandsController {

    @Autowired
    private IBrandSearchUsecase usecase;

    @GetMapping(value = "/")
    public String searchHandler(@PathVariable("userId") Long userId, @RequestParam("inputDataJson") String inputDataJson) {
        try {
            BrandSearchInputData inputData = super.MAPPER.readValue(inputDataJson, BrandSearchInputData.class);

            return super.MAPPER.writeValueAsString(this.usecase.search(userId, inputData));

        } catch (JsonProcessingException jpe) {
            jpe.printStackTrace();

            return null;
        } catch (IOException ioe) {
            ioe.printStackTrace();

            return null;
        }
    }
}
