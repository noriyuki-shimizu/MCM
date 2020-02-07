package source.usecases.dto.response.clothes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Value;
import source.usecases.dto.response.brands.BrandAssistResponseModel;
import source.usecases.dto.response.genre.GenreKeyValueResponseModel;
import source.usecases.dto.response.shops.ShopAssistResponseModel;

import java.math.BigDecimal;
import java.util.Set;

@Value(staticConstructor = "of")
@Data
public class ClothesResponseModel {
    private Long id;

    private Long imageId;

    private String imageLink;

    private BrandAssistResponseModel brand;

    private ShopAssistResponseModel shop;

    private Set<GenreKeyValueResponseModel> genres;

    private Integer price;

    private String buyDate;

    private String comment;

    private BigDecimal satisfaction;

    @JsonProperty("isDeleted")
    private Boolean isDeleted;
}
