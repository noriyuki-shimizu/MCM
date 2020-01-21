package source.usecases.dto.request.brands;

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
