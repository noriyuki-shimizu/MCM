package source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import source.annotation.NonAuth;
import source.domain.auth.AnalysisRequestHeader;
import source.domain.entity.db.Users;
import source.domain.repository.db.UsersRepository;
import source.infrastructure.firebase.Firebase;
import source.domain.entity.firebase.FirebaseVerifiedToken;

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
        if (userId.isEmpty() || token.isEmpty()) {
            response.sendError(403, "Invalid access token.");
            return false;
        }

        Optional<FirebaseVerifiedToken> decodedTokenOpt = this.firebase.getDecodedToken(token.get());
        if (decodedTokenOpt.isEmpty()) {
            response.sendError(403, "Request token is invalid or expired.");
            return false;
        }
        FirebaseVerifiedToken firebaseVerifiedToken = decodedTokenOpt.get();
        Optional<Users> users = this.usersRepository.findByIdAndUid(userId.get(), firebaseVerifiedToken.getUid());
        if (users.isEmpty()) {
            response.sendError(401, "Requested user does not exist.");
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {}

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {}
}
