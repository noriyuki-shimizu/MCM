package source.controller.brands.crud.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@AllArgsConstructor(onConstructor = @__(@JsonIgnore))
@NoArgsConstructor
public class BrandCreateRequestModel {
    private String name;

    private String link;

    private String imageLink;

    private String country;
}
