package source.usecases.dto.response.shops;

import lombok.Data;
import lombok.Value;

import java.util.List;

@Value(staticConstructor = "of")
@Data
public class ShopResponseViewModels {
    private List<ShopResponseModel> shops;
}
