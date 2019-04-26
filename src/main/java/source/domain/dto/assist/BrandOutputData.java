package source.domain.dto.assist;

import lombok.Value;

@Value(staticConstructor = "of")
public class BrandOutputData {

    private Integer id;

    private String name;

}

