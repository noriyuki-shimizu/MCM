package source.usecases.dto.input.shops;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor(onConstructor = @__(@JsonIgnore))
@NoArgsConstructor
public class ShopSearchInputData {
    private String name;

    private String stationName;

    private String address;

    private Boolean isDeleted;
}
