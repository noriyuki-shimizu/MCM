package source.domain.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RequestHeaderNames {
    USER_ID("UserId"),
    AUTHORIZATION("Authorization")
    ;

    private String key;
}
