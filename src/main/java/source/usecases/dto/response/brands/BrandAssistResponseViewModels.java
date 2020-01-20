package source.usecases.dto.response.brands;

import lombok.Value;

import java.util.List;

@Value(staticConstructor = "of")
public class BrandAssistResponseViewModels {
    private List<BrandAssistResponseModel> assistBrands;
}
