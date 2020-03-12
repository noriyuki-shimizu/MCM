package source.controller.clothes.curd.response;

import lombok.Value;

import java.util.List;

@Value(staticConstructor = "of")
public class ClothesResponseViewModels {
    private List<ClothesResponseModel> clothes;
}
