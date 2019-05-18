package source.domain.dto.assist;

import lombok.Value;

@Value(staticConstructor = "of")
public class ShopOutputData {

    private Long id;

    private String name;

}
