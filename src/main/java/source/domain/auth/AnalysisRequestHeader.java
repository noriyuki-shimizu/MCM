package source.domain.auth;

import lombok.Value;
import org.apache.commons.lang.math.NumberUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Value(staticConstructor = "of")
public class AnalysisRequestHeader {

    HttpServletRequest request;

    /**
     * ユーザ ID を取得します.
     * return {Long} userId
     */
    public Long getUserId() {
        final String userIdKey = RequestHeaderNames.USER_ID.getKey();
        final Optional<String> userIdOpt = Optional.ofNullable(request.getHeader(userIdKey));

        if (userIdOpt.isEmpty()) {
            return null;
        }

        String userId = userIdOpt.get();
        if (!NumberUtils.isDigits(userId)) {
            return null;
        }

        return Long.parseLong(userId);
    }

    /**
     * リクエストヘッダからトークンを取得します.
     * @return token
     */
    public String getToken() {
        final String authorizationKey = RequestHeaderNames.AUTHORIZATION.getKey();
        final Optional<String> authorization = Optional
                .ofNullable(request.getHeader(authorizationKey));

        return authorization
                .filter(token -> token.startsWith("Bearer "))
                .map(token -> token.replace("Bearer ", ""))
                .orElse(null);
    }

}
