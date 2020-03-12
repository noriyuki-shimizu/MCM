package source.controller.brands.crud.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@AllArgsConstructor(onConstructor = @__(@JsonIgnore))
@NoArgsConstructor
public class BrandUpdateRequestModel {
    private String name;

    private String link;

    private Long imageId;

    private String imageLink;

    private String country;
}
