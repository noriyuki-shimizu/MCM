package source.controller.clothes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import source.domain.dto.input.clothes.ClothesSearchInputData;
import source.usecases.clothes.IClothesSearchUsecase;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ClothesSearchController extends ClothesListController {

    @Autowired
    private IClothesSearchUsecase usecase;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @GetMapping("/search")
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
