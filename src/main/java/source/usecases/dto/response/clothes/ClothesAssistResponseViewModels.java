package source.usecases.dto.response.clothes;

import lombok.Value;

import java.util.List;

@Value(staticConstructor = "of")
public class ClothesAssistResponseViewModels {
    private List<ClothesAssistResponseModel> assistClothes;
}
