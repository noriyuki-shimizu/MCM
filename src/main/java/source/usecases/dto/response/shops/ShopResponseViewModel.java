package source.usecases.dto.response.shops;

import lombok.Data;
import lombok.Value;

@Value(staticConstructor = "of")
@Data
public class ShopResponseViewModel {
    private ShopResponseModel shop;
}
