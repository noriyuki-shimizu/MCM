package source.controller.brands.crud;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import source.controller.brands.BrandsController;
import source.usecases.dto.input.brands.BrandSearchInputData;
import source.usecases.app.brands.IBrandSearchUsecase;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BrandsSearchController extends BrandsController {

    @Autowired
    private IBrandSearchUsecase usecase;

    @GetMapping(value = "/")
    public String searchHandler(@PathVariable("userId") Long userId, @RequestParam("inputDataJson") String inputDataJson) {
        try {
            BrandSearchInputData inputData = super.MAPPER.readValue(inputDataJson, BrandSearchInputData.class);

            return super.MAPPER.writeValueAsString(this.usecase.search(userId, inputData));

        } catch (JsonProcessingException jpe) {
            log.error("JSON の変換エラー", jpe);

            return null;
        } catch (IOException ioe) {
            log.error("JSON の読み込みエラー", ioe);

            return null;
        }
    }
}
