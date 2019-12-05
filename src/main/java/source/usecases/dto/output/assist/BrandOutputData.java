package source.usecases.dto.output.assist;

import lombok.Value;
import source.usecases.dto.output.OutputBase;

@Value(staticConstructor = "of")
public class BrandOutputData extends OutputBase {

    private Long id;

    private String name;

}

