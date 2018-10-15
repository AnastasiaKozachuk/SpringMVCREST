package com.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import java.io.IOException;
import java.util.Enumeration;

@Component
public class RequestLoggingInterceptor extends HandlerInterceptorAdapter {

    private final Logger log = LoggerFactory.getLogger(this.getClass());



    private void logRequest(HttpServletRequest request) throws IOException {
            log.info("===========================request begin================================================");
            log.info("URI         : {}", request.getRequestURI());
            log.info("Method      : {}", request.getMethod());
            getAllHeaders(request);
            log.info("==========================request end================================================");
    }

    private void getAllHeaders(HttpServletRequest request){
        Enumeration<String> headerNames = request.getHeaderNames();
        log.info("Headers -> ");
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                log.info(headerName+" : "+ request.getHeader(headerName));
            }
        }

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logRequest(request);
        return true;
    }
}

