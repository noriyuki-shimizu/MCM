package source.usecases.dto.response.brands;

import lombok.Value;

@Value(staticConstructor = "of")
public class BrandAssistResponseModel {

    private Long id;

    private String name;

}

