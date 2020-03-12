package source.controller.genres.crud.response;

import lombok.Value;

@Value(staticConstructor = "of")
public class TotalPricePerGenreModel {
    private String name;

    private String color;

    private Integer totalPrice;
}
