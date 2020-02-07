package source.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import source.domain.entity.Genres;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum GenreColor {
    PINK("pink"),
    RED("red"),
    ORANGE("orange"),
    GREEN("green"),
    CYAN("cyan"),
    BLUE("blue"),
    PURPLE("purple"),
    YELLOW("yellow"),
    GOLDENROD("goldenrod"),
    GRAY("gray"),
    BLACK("black"),
    NAVY("navy"),
    OLIVE("olive"),
    LIGHT_SKY_BLUE("lightskyblue"),
    SLATE_GRAY("slategray"),
    DARK_ORANGE("darkorange"),
    DARK_RED("darkred"),
    INDIGO("indigo"),
    DARK_BLUE("darkblue"),
    YELLOW_GREEN("yellowgreen");

    private String key;

    public static List<String> acceptCanSelectedColors(List<String> selectedColors) {
        return Stream.of(GenreColor.values())
                .map(GenreColor::getKey)
                .filter(color -> !selectedColors.contains(color))
                .collect(Collectors.toList());
    }
}
