package source;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.MappedInterceptor;
import source.infrastructure.firebase.Firebase;

@Configuration
public class ApplicationConfig {
    @Bean
    public Interceptor getInstanceInterceptor() {
        return new Interceptor();
    }

    @Bean
    public MappedInterceptor interceptor() {
        return new MappedInterceptor(new String[]{"/**"}, getInstanceInterceptor());
    }

    @Bean
    public Firebase firebase() {
        return new Firebase();
    }
}
