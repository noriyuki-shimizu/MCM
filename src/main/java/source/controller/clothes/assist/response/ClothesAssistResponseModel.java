package source.controller.clothes.assist.response;

import lombok.Value;

import java.math.BigDecimal;
import java.util.Set;

@Value(staticConstructor = "of")
public class ClothesAssistResponseModel {
    private Long id;

    private String imageLink;

    private String brandName;

    private String shopName;

    private Set<ClothesGenreResponseModel> genres;

    private Integer price;

    private String buyDate;

    private String comment;

    private BigDecimal satisfaction;
}
