package source.controller.shops.crud.response;

import lombok.Value;

import java.util.List;

@Value(staticConstructor = "of")
public class ShopResponseViewModels {
    private List<ShopResponseModel> shops;
}
