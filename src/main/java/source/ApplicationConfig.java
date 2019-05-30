package source;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.MappedInterceptor;

@Configuration
public class ApplicationConfig {
    @Bean
    public Interceptor sampleInterceptor() {
        return new Interceptor();
    }

    @Bean
    public MappedInterceptor interceptor() {
        return new MappedInterceptor(new String[]{"/**"}, sampleInterceptor());
    }
}
