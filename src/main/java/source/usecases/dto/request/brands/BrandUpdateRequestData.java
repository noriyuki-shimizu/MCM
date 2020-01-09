package source.usecases.dto.request.brands;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import source.domain.entity.Brands;
import source.usecases.dto.request.images.ImageUpdateRequestData;

@Data
@AllArgsConstructor(onConstructor = @__(@JsonIgnore))
@NoArgsConstructor
public class BrandUpdateRequestData {
    private String name;

    private String link;

    private Long imageId;

    private String imageLink;

    private String country;
}
