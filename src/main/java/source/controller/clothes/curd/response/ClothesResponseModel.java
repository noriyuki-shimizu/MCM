package source.controller.clothes.curd.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Value;
import source.controller.brands.assist.response.BrandAssistResponseModel;
import source.controller.genres.assist.response.GenreKeyValueResponseModel;
import source.controller.shops.assist.response.ShopAssistResponseModel;

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
