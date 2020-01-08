package source.domain.vo;

import lombok.Value;
import source.domain.entity.Brands;
import source.domain.entity.Images;

@Value(staticConstructor = "of")
public class BrandCreateData {
    private Long userId;

    private String name;

    private String link;

    private String imageLink;

    private String country;

    public Brands toEntity() {
        return Brands.builder()
                .userId(this.userId)
                .name(this.name)
                .link(this.link)
                .image(
                        this.imageLink != null
                                ? Images.builder()
                                    .path(this.imageLink)
                                    .build()
                                : null
                )
                .country(this.country)
                .build();
    }
}
