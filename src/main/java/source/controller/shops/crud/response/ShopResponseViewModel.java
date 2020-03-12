package source.controller.shops.crud.response;

import lombok.Value;

@Value(staticConstructor = "of")
public class ShopResponseViewModel {
    private ShopResponseModel shop;
}
