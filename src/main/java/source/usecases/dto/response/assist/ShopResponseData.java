package source.usecases.dto.response.assist;

import lombok.Value;

@Value(staticConstructor = "of")
public class ShopResponseData {

    private Long id;

    private String name;

}
