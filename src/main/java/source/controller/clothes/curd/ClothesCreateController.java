package source.controller.clothes.curd;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import source.controller.clothes.ClothesController;
import source.usecases.dto.request.clothes.ClothesCreateRequestData;
import source.usecases.app.clothes.IClothesCreateUsecase;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ClothesCreateController extends ClothesController {

    @Autowired
    private IClothesCreateUsecase usecase;

    @PostMapping("/")
    public String createHandler(@PathVariable("userId") Long userId, @RequestParam("inputDataJson") String inputDataJson) {
        try {
            ClothesCreateRequestData inputData = super.MAPPER.readValue(inputDataJson, ClothesCreateRequestData.class);

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
