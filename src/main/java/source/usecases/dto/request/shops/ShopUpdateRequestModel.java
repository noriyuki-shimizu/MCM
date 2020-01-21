package source.usecases.dto.request.shops;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@AllArgsConstructor(onConstructor = @__(@JsonIgnore))
@NoArgsConstructor
public class ShopUpdateRequestModel {
    private String name;

    private String link;

    private String stationName;

    private Long imageId;

    private String imageLink;

    private String address;

    private String businessHours;

    private String tel;
}
