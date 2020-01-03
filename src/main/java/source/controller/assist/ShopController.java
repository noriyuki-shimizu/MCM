package source.controller.assist;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import source.usecases.dto.response.assist.ShopResponseData;
import source.usecases.app.assist.IAssistShopSearchUsecase;

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
            List<ShopResponseData> shopResponseDataList = this.usecase.getAssistShopList();

            return MAPPER.writeValueAsString(shopResponseDataList);
        } catch (JsonProcessingException jpe) {
            log.error("JSON の変換エラー", jpe);

            return null;
        }
    }

}
