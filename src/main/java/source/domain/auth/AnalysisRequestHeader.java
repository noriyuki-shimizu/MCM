package source.domain.auth;

import lombok.Value;

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
        final Optional<String> userId = Optional.ofNullable(this.request.getHeader("UserId"));

        return userId
                .map(Long::parseLong)
                .orElse(null);
    }

    /**
     * リクエストヘッダからトークンを取得します.
     * @return token
     */
    public String getToken() {
        final Optional<String> authorization = Optional
                .ofNullable(this.request.getHeader("Authorization"));

        return authorization
                .filter(token -> token.startsWith("Bearer "))
                .map(token -> token.replace("Bearer ", ""))
                .orElse(null);
    }

}
