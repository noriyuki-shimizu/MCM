package source.usecases.dto.response.shops;

import lombok.Value;

@Value(staticConstructor = "of")
public class ShopResponseViewModel {
    private ShopResponseModel shop;
}
