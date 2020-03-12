package source.controller.images.fashion.response;

import lombok.Value;

import java.util.List;

@Value(staticConstructor = "of")
public class ImageAddressResponseData {
    private List<String> imageAddresses;
}
