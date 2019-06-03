package source.domain.env;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "auth.security")
@Data
public class AuthEnv {
    private String secret = "secret";
    private Long expirationTime = 100000L;
}
