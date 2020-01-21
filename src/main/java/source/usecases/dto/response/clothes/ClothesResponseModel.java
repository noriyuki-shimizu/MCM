package source.usecases.dto.response.clothes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Value;
import source.usecases.dto.response.brands.BrandAssistResponseModel;
import source.usecases.dto.response.genre.GenreAssistResponseModel;
import source.usecases.dto.response.shops.ShopAssistResponseModel;

import java.time.LocalDate;
import java.util.Set;

@Value(staticConstructor = "of")
@Data
public class ClothesResponseModel {
    private Long id;

    private Long imageId;

    private String imageLink;

    private BrandAssistResponseModel brand;

    private ShopAssistResponseModel shop;

    private Set<GenreAssistResponseModel> genres;

    private Integer price;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate buyDate;

    private String comment;

    private Float satisfaction;

    @JsonProperty("isDeleted")
    private Boolean isDeleted;
}
