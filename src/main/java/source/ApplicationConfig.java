package source;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.MappedInterceptor;

@Configuration
public class ApplicationConfig extends WebMvcConfigurerAdapter {
    @Bean
    public Interceptor getInstanceInterceptor() {
        return new Interceptor();
    }

    @Bean
    public MappedInterceptor interceptor() {
        return new MappedInterceptor(new String[]{"/**"}, getInstanceInterceptor());
    }
}
