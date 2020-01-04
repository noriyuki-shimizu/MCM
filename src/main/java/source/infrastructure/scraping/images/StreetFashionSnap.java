package source.infrastructure.scraping.images;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
@ConfigurationProperties(prefix = "settings.scraping.images")
@Data
@Slf4j
public class StreetFashionSnap implements IScrapingImage {
    private String streetFashionSnapUrl;

    @Override
    public List<String> pickImageAddresses() throws UnsupportedEncodingException, IOException {
        String accessURL = new StringBuilder()
                .append(URLDecoder.decode(this.streetFashionSnapUrl, "UTF-8"))
                .append(new Random().nextInt(100) + 1)
                .toString();

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
