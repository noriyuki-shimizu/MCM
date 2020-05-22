package source.domain.logging;

import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.List;

@Slf4j(topic = "source.crud")
public class CrudLogging {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static <T> void logging(final LoggingHead head, final Long userId, final T item) {
        try {
            log.info("{} userId = {}, data = {}", head.getKey(), userId, MAPPER.writeValueAsString(item));
        } catch (IOException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public static <T> void logging(final LoggingHead head, final String userId, final List<T> items) {
        items.forEach(item -> {
            try {
                log.info("{} userId = {}, data = {}", head.getKey(), userId, MAPPER.writeValueAsString(item));
            } catch (IOException e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }
        });
    }

    public static <T> void logging(final LoggingHead head, final List<T> items) {
        items.forEach(item -> {
            try {
                log.info("{} [BULK] data = {}", head.getKey(), MAPPER.writeValueAsString(item));
            } catch (IOException e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }
        });
    }
}
