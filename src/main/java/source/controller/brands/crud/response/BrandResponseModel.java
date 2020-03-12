package source.controller.brands.crud.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Value;

@Value(staticConstructor = "of")
@Data
public class BrandResponseModel {
    private Long id;

    private String name;

    private String link;

    private Long imageId;

    private String imageLink;

    private String country;

    @JsonProperty("isDeleted")
    private Boolean isDeleted;
}
