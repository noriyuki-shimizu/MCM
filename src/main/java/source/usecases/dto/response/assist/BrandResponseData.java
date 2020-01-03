package source.usecases.dto.response.assist;

import lombok.Value;
import source.usecases.dto.response.ResponseBase;

@Value(staticConstructor = "of")
public class BrandResponseData extends ResponseBase {

    private Long id;

    private String name;

}

