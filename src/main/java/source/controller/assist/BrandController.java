package source.controller.assist;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import source.domain.dto.output.assist.BrandOutputData;
import source.usecases.assist.IAssistBrandSearchUsecase;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/assist/brand")
@Slf4j
public class BrandController {

    @Autowired
    private IAssistBrandSearchUsecase usecase;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @RequestMapping(value = "/keyValueList")
    public String keyValueList() {
        try {
            List<BrandOutputData> brandOutputDataList = this.usecase.getAssistBrandList();

            return MAPPER.writeValueAsString(brandOutputDataList);
        } catch (JsonProcessingException jpe) {
            log.error("JSON の変換エラー", jpe);

            return null;
        }
    }
}
