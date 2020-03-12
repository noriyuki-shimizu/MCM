package source.controller.genres.crud.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(onConstructor = @__(@JsonIgnore))
@NoArgsConstructor
public class GenreUpdateRequestModel {
    private Long id;

    private String name;

    private String color;
}
