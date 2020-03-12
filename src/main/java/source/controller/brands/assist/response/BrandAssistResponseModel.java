package source.controller.brands.assist.response;

import lombok.Value;

@Value(staticConstructor = "of")
public class BrandAssistResponseModel {

    private Long id;

    private String name;

}

