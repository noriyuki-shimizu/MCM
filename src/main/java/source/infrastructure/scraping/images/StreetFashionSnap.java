package source.infrastructure.scraping.images;

import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
@ConfigurationProperties(prefix = "settings.scraping.images")
@Data
public class StreetFashionSnap implements IScrapingImage {
    private String streetFashionSnapUrl;

    @Override
    public List<String> pickImageAddresses() throws IOException {
        String accessURL = URLDecoder.decode(this.streetFashionSnapUrl, StandardCharsets.UTF_8.name()) +
                (new Random().nextInt(100) + 1);

        Document document = Jsoup
                .connect(accessURL)
                .get();
        Elements elements = document.select("div.the-photo a.permalink img");

        if (!(elements == null || elements.isEmpty())) {
            return elements
                    .stream()
                    .map(element -> element.attr("src"))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
