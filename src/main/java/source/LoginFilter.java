package source;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.OncePerRequestFilter;
import source.domain.entity.BUser;
import source.domain.repository.security.LoginUser;
import source.usecases.IUserFindUsecase;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter extends OncePerRequestFilter {

    @Autowired
    private IUserFindUsecase usecase;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        SecurityContextHolder.getContext().setAuthentication(new PreAuthenticatedAuthenticationToken(
                auth(request), null));

        filterChain.doFilter(request, response);
    }

    private LoginUser auth(HttpServletRequest request) {

        String token = getToken(request);

        try {
            // idToken comes from the client app (shown above)
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
            String uid = decodedToken.getUid();

            // uidを取得し、ユーザ情報を検索
            BUser user = usecase.findByUid(uid);

            if(user == null){
                throw new BadCredentialsException("User not found.");
            }

            return new LoginUser(user);

        } catch (Exception e) {
            throw new BadCredentialsException("Token is invalid");
        }
    }

    /**
     * リクエストヘッダからトークンを取得します.
     * @param request
     * @return token
     */
    private String getToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer ")) {
            return null;
        }
        return token.replace("Bearer ", "");
    }

}
