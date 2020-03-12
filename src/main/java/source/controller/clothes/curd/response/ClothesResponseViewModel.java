package source.controller.clothes.curd.response;

import lombok.Value;

@Value(staticConstructor = "of")
public class ClothesResponseViewModel {
    private ClothesResponseModel clothes;
}
