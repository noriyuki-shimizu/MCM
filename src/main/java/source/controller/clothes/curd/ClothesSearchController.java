package source.controller.clothes.curd;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import source.controller.clothes.ClothesController;
import source.usecases.dto.input.clothes.ClothesSearchInputData;
import source.usecases.app.clothes.IClothesSearchUsecase;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ClothesSearchController extends ClothesController {

    @Autowired
    private IClothesSearchUsecase usecase;

    @GetMapping("/")
    public String search(@PathVariable("userId") Long userId, @RequestParam("inputDataJson") String inputDataJson) {
        try {
            ClothesSearchInputData inputData = super.MAPPER.readValue(inputDataJson, ClothesSearchInputData.class);

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
