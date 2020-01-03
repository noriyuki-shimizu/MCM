package source.usecases.dto.request.shops;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor(onConstructor = @__(@JsonIgnore))
@NoArgsConstructor
public class ShopSearchRequestData {
    private String name;

    private String stationName;

    private String address;

    private Boolean isDeleted;
}
