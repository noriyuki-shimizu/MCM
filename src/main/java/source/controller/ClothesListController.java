package source.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import source.domain.dto.clothes.ClothesSearchInputData;
import source.usecases.IClothesSearchUsecase;

import java.io.IOException;
import java.util.Date;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/clothesList")
public class ClothesListController {

    @Autowired
    private IClothesSearchUsecase usecase;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam("inputDataJson") String inputDataJson) {
        try {
            ClothesSearchInputData inputData = MAPPER.readValue(inputDataJson, ClothesSearchInputData.class);

            return MAPPER.writeValueAsString(this.usecase.search(inputData));

        } catch (JsonProcessingException jpe) {
            jpe.printStackTrace();

            return null;
        } catch (IOException ioe) {
            // TODO: ログへの書き出し処理を追加すること
            ioe.printStackTrace();

            return null;
        }

    }
}
