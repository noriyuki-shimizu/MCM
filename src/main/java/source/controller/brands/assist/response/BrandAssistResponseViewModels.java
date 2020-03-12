package source.controller.brands.assist.response;

import lombok.Value;

import java.util.List;

@Value(staticConstructor = "of")
public class BrandAssistResponseViewModels {
    private List<BrandAssistResponseModel> assistBrands;
}
