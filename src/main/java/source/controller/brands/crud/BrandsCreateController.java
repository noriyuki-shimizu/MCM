package source.controller.brands.crud;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import source.controller.brands.BrandsController;
import source.usecases.dto.input.brands.BrandCreateInputData;
import source.usecases.app.brands.IBrandCreateUsecase;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BrandsCreateController extends BrandsController {

    @Autowired
    private IBrandCreateUsecase usecase;

    @PostMapping(value = "/")
    public String createHandler(@PathVariable("userId") Long userId, @RequestParam("inputDataJson") String inputDataJson) {
        try {
            BrandCreateInputData inputData = super.MAPPER.readValue(inputDataJson, BrandCreateInputData.class);

            return super.MAPPER.writeValueAsString(this.usecase.create(userId, inputData));
        } catch (JsonProcessingException jpe) {
            log.error("JSON の変換エラー", jpe);

            return null;
        } catch (IOException ioe) {
            log.error("JSON の読み込みエラー", ioe);

            return null;
        }
    }
}
