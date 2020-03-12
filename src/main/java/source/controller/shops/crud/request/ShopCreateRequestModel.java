package source.controller.shops.crud.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@AllArgsConstructor(onConstructor = @__(@JsonIgnore))
@NoArgsConstructor
public class ShopCreateRequestModel {
    private String name;

    private String link;

    private String stationName;

    private String imageLink;

    private String address;

    private String businessHours;

    private String tel;
}
