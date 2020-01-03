package source.usecases.dto.response.brands;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Value;
import source.domain.entity.Images;

@Value(staticConstructor = "of")
@Data
public class BrandResponseViewModel {
    private Long id;

    private Long userId;

    private String name;

    private String link;

    private Images image;

    private String country;

    @JsonProperty("isDeleted")
    private Boolean isDeleted;
}
