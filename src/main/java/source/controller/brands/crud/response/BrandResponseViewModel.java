package source.controller.brands.crud.response;

import lombok.Value;

@Value(staticConstructor = "of")
public class BrandResponseViewModel {
    private BrandResponseModel brand;
}
