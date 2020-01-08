package source.usecases.dto.response.brands;

import lombok.Value;

@Value(staticConstructor = "of")
public class BrandResponseViewModel {
    private BrandResponseModel brand;
}
