package source;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import source.annotation.NonAuth;
import source.domain.auth.AnalysisRequestHeader;
import source.domain.entity.Users;
import source.infrastructure.firebase.Firebase;
import source.domain.repository.db.UsersRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Optional;

public class Interceptor implements HandlerInterceptor {

    @Autowired
    private Firebase firebase;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof ResourceHttpRequestHandler) {
            return true;
        }

        HandlerMethod hm = (HandlerMethod) handler;
        Method method = hm.getMethod();
        Optional<NonAuth> annotation = Optional.ofNullable(
                AnnotationUtils.findAnnotation(method, NonAuth.class)
        );
        if (annotation.isPresent()) {
            return true;
        }

        AnalysisRequestHeader analysisRequestHeader = AnalysisRequestHeader.of(request);
        Optional<Long> userId = Optional.ofNullable(analysisRequestHeader.getUserId());
        Optional<String> token = Optional.ofNullable(analysisRequestHeader.getToken());
        if (!userId.isPresent() || !token.isPresent()) {
            response.sendError(403, "Invalid access token.");
            return false;
        }

        try {
            FirebaseToken decodedToken = this.firebase.getDecodedToken(token.get());
            Optional<Users> users = Optional.ofNullable(
                    this.usersRepository.findByIdAndUid(userId.get(), decodedToken.getUid())
            );
            if (!users.isPresent()) {
                response.sendError(401, "Requested user does not exist.");
                return false;
            }
        } catch(FirebaseAuthException fae) {
            response.sendError(403, "Request token is invalid or expired.");
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
