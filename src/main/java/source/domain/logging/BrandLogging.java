package source.domain.logging;

import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;
import source.domain.entity.db.Brands;

import java.io.IOException;
import java.util.List;

@Slf4j(topic = "source.domain.logging")
public class BrandLogging {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static void deleteLogging(final List<Brands> brands) {
        brands.forEach(deletedBrand -> {
            try {
                log.info("delete brand. userId: {}, data: {}", deletedBrand.getUserId(), MAPPER.writeValueAsString(deletedBrand));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
