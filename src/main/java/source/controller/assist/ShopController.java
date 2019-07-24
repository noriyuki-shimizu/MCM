package source.controller.assist;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import source.domain.dto.output.assist.ShopOutputData;
import source.usecases.assist.IAssistShopSearchUsecase;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/assist/shop")
@Slf4j
public class ShopController {

    @Autowired
    private IAssistShopSearchUsecase usecase;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @RequestMapping(value = "/keyValueList")
    public String keyValueList() {
        try {
            List<ShopOutputData> shopOutputDataList = this.usecase.getAssistShopList();

            return MAPPER.writeValueAsString(shopOutputDataList);
        } catch (JsonProcessingException jpe) {
            log.error("JSON の変換エラー", jpe);

            return null;
        }
    }

}
