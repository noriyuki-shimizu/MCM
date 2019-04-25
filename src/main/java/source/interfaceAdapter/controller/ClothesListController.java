package source.interfaceAdapter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import source.domain.dto.clothes.ClothesSearchInputData;
import source.usecases.IClothesSearchUsecase;

import java.util.Date;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/clothesList")
public class ClothesListController {

    @Autowired
    private IClothesSearchUsecase usecase;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search() {
        // TODO: とりあえず、テンプレートとしてオブジェクトを宣言
        ClothesSearchInputData inputData = ClothesSearchInputData.builder()
                .brandId(0)
                .genreId(0)
                .shopId(0)
                .morePrice(0)
                .lessPrice(0)
                .buyDate(new Date())
                .deleteFlag(false)
                .build();

        try {
            return MAPPER.writeValueAsString(this.usecase.search(inputData));
        } catch(JsonProcessingException jpe) {
            jpe.printStackTrace();

            return null;
        }
    }
}
