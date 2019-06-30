package source.domain.dto.output.assist;

import lombok.Value;
import source.domain.dto.output.OutputBase;

@Value(staticConstructor = "of")
public class BrandOutputData extends OutputBase {

    private Long id;

    private String name;

}

