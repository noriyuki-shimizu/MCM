package source;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import source.domain.auth.AnalysisRequestHeader;

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
        log.info("[API START] [userId = {}] api called.", analysisRequestHeader.getUserId());

        final HttpServletRequest requestCacheWrapperObject = new ContentCachingRequestWrapper((HttpServletRequest) request);
        final String requestURI = requestCacheWrapperObject.getRequestURI();
        final String method = requestCacheWrapperObject.getMethod();
        log.info("[API RESOURCE] {}#{}", method, requestURI);

        Map<String, String[]> parameterMap = requestCacheWrapperObject.getParameterMap();
        parameterMap.forEach((key, value) -> log.info("[API INPUT PARAM] {} = {}", key, Arrays.toString(value)));

        chain.doFilter(request, response);

        ContentCachingResponseWrapper contentCachingResponseWrapper = new ContentCachingResponseWrapper((HttpServletResponse) response);

        log.info("[API RESPONSE] httpStatus = {}", contentCachingResponseWrapper.getStatusCode());
        log.info("[API END] in {} ms", System.currentTimeMillis() - start);
    }

    @Override
    public void destroy() {
    }
}