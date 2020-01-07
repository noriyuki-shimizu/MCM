package source.domain.auth;

import lombok.Value;

import javax.servlet.http.HttpServletRequest;

@Value(staticConstructor = "of")
public class RequestToken {

    private HttpServletRequest request;

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
