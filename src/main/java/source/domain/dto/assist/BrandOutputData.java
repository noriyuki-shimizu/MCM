package source.domain.dto.assist;

import lombok.Value;

@Value(staticConstructor = "of")
public class BrandOutputData {

    private Long id;

    private String name;

}

