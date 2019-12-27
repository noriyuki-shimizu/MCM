package source.controller.images.fashion;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import source.controller.images.ImageController;
import source.domain.vo.ImageAddresses;
import source.usecases.app.images.IGetImageAddressUsecase;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/street-fashion-snap")
public class StreetFashionSnapController extends ImageController {
    @Autowired
    private IGetImageAddressUsecase usecase;

    @GetMapping("/")
    public String getImages() {
        try {
            ImageAddresses imageAddresses = this.usecase.handle();
            return super.MAPPER.writeValueAsString(imageAddresses.getValues());
        } catch (JsonProcessingException jpe) {
            log.error("JSON の変換エラー", jpe);

            return null;
        }
    }
}
