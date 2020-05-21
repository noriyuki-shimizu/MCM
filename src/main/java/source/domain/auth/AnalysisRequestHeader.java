package source.domain.auth;

import lombok.Value;
import source.RequestHeaderNames;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Value(staticConstructor = "of")
public class AnalysisRequestHeader {

    private HttpServletRequest request;

    /**
     * ユーザ ID を取得します.
     * return {Long} userId
     */
    public Long getUserId() {
        final String userIdKey = RequestHeaderNames.USER_ID.getKey();
        final Optional<String> userId = Optional.ofNullable(request.getHeader(userIdKey));

        return userId
                .map(Long::parseLong)
                .orElse(null);
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
