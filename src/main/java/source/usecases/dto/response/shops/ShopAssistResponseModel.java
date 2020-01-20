package source.usecases.dto.response.shops;

import lombok.Value;

@Value(staticConstructor = "of")
public class ShopAssistResponseModel {

    private Long id;

    private String name;

}
