package source.usecases.dto.request.brands;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import source.domain.entity.Brands;
import source.usecases.dto.request.images.ImageUpdateRequestData;

@Data
@AllArgsConstructor(onConstructor = @__(@JsonIgnore))
@NoArgsConstructor
public class BrandUpdateRequestData {
    private Long id;

    private String name;

    private String link;

    private String imageLink;

    private String country;
}
