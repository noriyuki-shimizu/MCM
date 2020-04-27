package source.domain.logging;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import source.domain.entity.db.Shops;

import java.io.IOException;
import java.util.List;

@Slf4j(topic = "source.domain.logging")
public class ShopLogging {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static void deleteLogging(final List<Shops> shops) {
        shops.forEach(deletedShops -> {
            try {
                log.info("delete brand. userId: {}, data: {}", deletedShops.getUserId(), MAPPER.writeValueAsString(deletedShops));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
