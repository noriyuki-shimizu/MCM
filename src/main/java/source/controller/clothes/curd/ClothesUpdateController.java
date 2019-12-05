package source.controller.clothes.curd;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import source.controller.clothes.ClothesController;
import source.usecases.dto.input.clothes.ClothesUpdateInputData;
import source.usecases.app.clothes.IClothesUpdateUsecase;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ClothesUpdateController extends ClothesController {

    @Autowired
    private IClothesUpdateUsecase usecase;

    @PutMapping("/")
    public String updateHandler(@PathVariable("userId") Long userId, @RequestParam("inputDataJson") String inputDataJson) {
        try {
            ClothesUpdateInputData inputData = super.MAPPER.readValue(inputDataJson, ClothesUpdateInputData.class);

            return super.MAPPER.writeValueAsString(this.usecase.update(userId, inputData));

        } catch (JsonProcessingException jpe) {
            log.error("JSON の変換エラー", jpe);

            return null;
        } catch (IOException ioe) {
            log.error("JSON の読み込みエラー", ioe);

            return null;
        }
    }
}
