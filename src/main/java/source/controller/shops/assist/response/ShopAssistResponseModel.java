package source.controller.shops.assist.response;

import lombok.Value;

@Value(staticConstructor = "of")
public class ShopAssistResponseModel {

    private Long id;

    private String name;

}
