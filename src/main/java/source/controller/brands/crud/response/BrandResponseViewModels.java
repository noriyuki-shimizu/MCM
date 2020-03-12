package source.controller.brands.crud.response;

import lombok.Value;

import java.util.List;

@Value(staticConstructor = "of")
public class BrandResponseViewModels {
    private List<BrandResponseModel> brands;
}
