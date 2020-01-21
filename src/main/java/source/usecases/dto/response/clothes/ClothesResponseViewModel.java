package source.usecases.dto.response.clothes;

import lombok.Value;

@Value(staticConstructor = "of")
public class ClothesResponseViewModel {
    private ClothesResponseModel clothes;
}
