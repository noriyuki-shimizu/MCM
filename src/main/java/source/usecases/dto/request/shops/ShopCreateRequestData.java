package source.usecases.dto.request.shops;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import source.domain.entity.Images;
import source.domain.entity.Shops;

@Builder
@Getter
@AllArgsConstructor(onConstructor = @__(@JsonIgnore))
@NoArgsConstructor
public class ShopCreateRequestData {
    private String name;

    private String link;

    private String stationName;

    private String imageName;

    private String imagePath;

    private String address;

    private String businessHours;

    private String tel;

    public Shops toEntity(Long userId) {
        Images image = Images.builder()
                .path(this.imagePath)
                .build();

        return Shops.builder()
                .name(this.name)
                .link(this.link)
                .stationName(this.stationName)
                .image(image)
                .address(this.address)
                .businessHours(this.businessHours)
                .tel(this.tel)
                .build();
    }
}
