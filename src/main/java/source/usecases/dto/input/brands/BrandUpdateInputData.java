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
public class BrandUpdateInputData {
    private Long id;

    private String name;

    private String link;

    private Long imageId;

    private String imageName;

    private String imagePath;

    private String country;

    private Boolean isDeleted;

    public Brands toEntity(Long userId) {
        Images image = Images.builder()
                .id(this.imageId)
                .name(this.imageName)
                .path(this.imagePath)
                .build();

        Brands brand = Brands.builder()
                .id(this.id)
                .userId(userId)
                .name(this.name)
                .link(this.link)
                .image(image)
                .country(this.country)
                .build();
        // TODO: ぶち殺したくなる実装
        brand.setDeleted(this.isDeleted);

        return brand;
    }
}
