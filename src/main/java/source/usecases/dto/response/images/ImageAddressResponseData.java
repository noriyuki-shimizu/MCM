package source.usecases.dto.response.images;

import lombok.Value;

import java.util.List;

@Value(staticConstructor = "of")
public class ImageAddressResponseData {
    private List<String> imageAddresses;
}
