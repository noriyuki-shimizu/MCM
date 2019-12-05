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
import source.domain.auth.RequestToken;
import source.domain.entity.Users;
import source.infrastructure.firebase.Firebase;
import source.domain.repository.db.UsersRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

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
        NonAuth annotation = AnnotationUtils.findAnnotation(method, NonAuth.class);
        if (annotation != null) {
            return true;
        }

        RequestToken requestToken = RequestToken.of(request);
        String token = requestToken.getToken();
        if (token == null) {
            return false;
        }

        try {
            FirebaseToken decodedToken = this.firebase.getDecodedToken(token);
            Users users = this.usersRepository.findByUidEquals(decodedToken.getUid());
            if (users == null) {
                return false;
            }
        } catch(FirebaseAuthException fae) {
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
