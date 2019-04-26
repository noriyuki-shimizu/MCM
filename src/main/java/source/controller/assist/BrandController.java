package source.controller.assist;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import source.domain.dto.assist.BrandOutputData;
import source.usecases.assist.IAssistBrandSearchUsecase;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/assist/brand")
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
            jpe.printStackTrace();

            return null;
        }
    }
}
