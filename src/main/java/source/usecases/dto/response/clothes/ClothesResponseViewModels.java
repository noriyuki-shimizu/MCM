package source.usecases.dto.response.clothes;

import lombok.Value;

import java.util.List;

@Value(staticConstructor = "of")
public class ClothesResponseViewModels {
    private List<ClothesResponseModel> clothes;
}
