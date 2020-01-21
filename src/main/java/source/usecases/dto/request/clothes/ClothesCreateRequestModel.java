package source.usecases.dto.request.clothes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor(onConstructor = @__(@JsonIgnore))
@NoArgsConstructor
public class ClothesCreateRequestModel {
    private String imageLink;

    private Long brandId;

    private Long shopId;

    private Set<Long> genreIds;

    private Integer price;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate buyDate;

    private String comment;

    private Float satisfaction;
}
