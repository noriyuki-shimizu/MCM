package source.domain.logging;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import source.domain.entity.db.Clothes;

import java.io.IOException;
import java.util.List;

@Slf4j(topic = "source.domain.logging")
public class ClothesLogging {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static void deleteLogging(final List<Clothes> clothes) {
        clothes.forEach(c -> {
            try {
                log.info("delete brand. userId: {}, data: {}", c.getUserId(), MAPPER.writeValueAsString(c));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
