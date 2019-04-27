package source.domain.dto.assist;

import lombok.Value;

@Value(staticConstructor = "of")
public class ShopOutputData {

    private Integer id;

    private String name;

}
