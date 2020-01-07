package source.domain.auth;

import lombok.Value;

import javax.servlet.http.HttpServletRequest;

@Value(staticConstructor = "of")
public class AnalysisRequestHeader {

    private HttpServletRequest request;

    /**
     * ユーザ ID を取得します.
     * return {Long} userId
     */
    public Long getUserId() {
        String userId = this.request.getHeader("UserId");
        if (userId == null) {
            return null;
        }
        return Long.parseLong(userId);
    }

    /**
     * リクエストヘッダからトークンを取得します.
     * @return token
     */
    public String getToken() {
        String token = this.request.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer ")) {
            return null;
        }
        return token.replace("Bearer ", "");
    }

}
