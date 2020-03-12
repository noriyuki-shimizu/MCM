package source.controller.images.fashion;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import source.controller.images.ImageController;
import source.usecases.app.images.IGetImageAddressUsecase;
import source.controller.images.fashion.response.ImageAddressResponseData;

@RestController
@Slf4j
public class StreetFashionSnapController extends ImageController {
    private static final String BASE_URL = "/street-fashion-snap";

    @Autowired
    private IGetImageAddressUsecase usecase;

    @GetMapping(BASE_URL + "/addresses")
    @ResponseStatus(HttpStatus.OK)
    public ImageAddressResponseData addresses() {
        return ImageAddressResponseData.of(this.usecase.handle());
    }
}
