package source.usecases.dto.input.brands;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import source.domain.entity.Brands;
import source.domain.entity.Images;

@Builder
@Getter
@AllArgsConstructor(onConstructor = @__(@JsonIgnore))
@NoArgsConstructor
public class BrandCreateInputData {
    private String name;

    private String link;

    private String imageName;

    private String imagePath;

    private String country;

    public Brands toEntity(Long userId) {
        Images image = Images.builder()
                .name(this.imageName)
                .path(this.imagePath)
                .build();

        return Brands.builder()
                .userId(userId)
                .name(this.name)
                .link(this.link)
                .image(image)
                .country(this.country)
                .build();
    }
}
