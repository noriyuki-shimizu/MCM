package source;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import source.domain.auth.AnalysisRequestHeader;
import source.domain.logging.LoggingHead;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@Component
@Slf4j
public class LoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        final long start = System.currentTimeMillis();

        AnalysisRequestHeader analysisRequestHeader = AnalysisRequestHeader.of((HttpServletRequest) request);
        log.info("{} [userId = {}] api called.", LoggingHead.START.getKey(), analysisRequestHeader.getUserId());

        final HttpServletRequest requestCacheWrapperObject = new ContentCachingRequestWrapper((HttpServletRequest) request);
        final String requestURI = requestCacheWrapperObject.getRequestURI();
        final String method = requestCacheWrapperObject.getMethod();
        log.info("{} {}#{}", LoggingHead.RESOURCES.getKey(), method, requestURI);

        Map<String, String[]> parameterMap = requestCacheWrapperObject.getParameterMap();
        parameterMap.forEach((key, value) -> log.info("{} {} = {}", LoggingHead.INPUT.getKey(), key, Arrays.toString(value)));

        chain.doFilter(request, response);

        ContentCachingResponseWrapper contentCachingResponseWrapper = new ContentCachingResponseWrapper((HttpServletResponse) response);

        log.info("{} httpStatus = {}", LoggingHead.RESOURCES.getKey(), contentCachingResponseWrapper.getStatusCode());
        log.info("{} in {} ms", LoggingHead.END.getKey(), System.currentTimeMillis() - start);
    }

    @Override
    public void destroy() {
    }
}