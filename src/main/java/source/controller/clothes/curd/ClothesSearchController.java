package source.controller.clothes.curd;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import source.controller.clothes.ClothesListController;
import source.domain.dto.input.clothes.ClothesSearchInputData;
import source.usecases.clothes.IClothesSearchUsecase;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ClothesSearchController extends ClothesListController {

    @Autowired
    private IClothesSearchUsecase usecase;

    @GetMapping("/")
    public String search(@RequestParam("inputDataJson") String inputDataJson) {
        try {
            ClothesSearchInputData inputData = super.MAPPER.readValue(inputDataJson, ClothesSearchInputData.class);

            return super.MAPPER.writeValueAsString(this.usecase.search(inputData));

        } catch (JsonProcessingException jpe) {
            log.error("JSON の変換エラー", jpe);

            return null;
        } catch (IOException ioe) {
            log.error("JSON の読み込みエラー", ioe);

            return null;
        }
    }

}
