package source.usecases.dto.input.brands;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import source.domain.entity.Brands;
import source.usecases.dto.input.images.ImageCreateInputData;

@Builder
@Getter
@AllArgsConstructor(onConstructor = @__(@JsonIgnore))
@NoArgsConstructor
public class BrandCreateInputData {
    private String name;

    private String link;

    private ImageCreateInputData image;

    private String country;

    public Brands toEntity(Long userId) {
        return Brands.builder()
                .userId(userId)
                .name(this.name)
                .link(this.link)
                .image(
                        this.image != null
                            ? this.image.toEntity()
                            : null
                )
                .country(this.country)
                .build();
    }
}
