package source.infrastructure.scraping.images;

import java.io.IOException;
import java.util.List;

public interface IScrapingImage {
    public List<String> pickImageAddresses() throws IOException;
}
