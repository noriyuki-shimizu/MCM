package source.infrastructure.scraping.images;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@ConfigurationProperties(prefix = "settings.scraping.images")
@Data
@Slf4j
public class StreetFashionSnap implements IScrapingImage {
    private String streetFashionSnapUrl;

    @Override
    public Elements getImageAddresses() {
        try {
            Document document = Jsoup
                    .connect(this.streetFashionSnapUrl)
                    .get();
            Elements elements = document.select("div.the-photo a.permalink");

            if (!(elements == null || elements.isEmpty())) {
                return elements;
            }
            return null;
        } catch (IOException ioe) {
            log.error("指定した URL にアクセスできませんでした。確認してください。", ioe);
            return null;
        }
    }
}
