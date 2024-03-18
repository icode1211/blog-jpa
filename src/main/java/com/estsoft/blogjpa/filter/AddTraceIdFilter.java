package com.estsoft.blogjpa.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.UUID;

@Slf4j
public class AddTraceIdFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("2. AddTraceIdFilter init() - {}", filterConfig.getFilterName());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setAttribute("traceId", UUID.randomUUID().toString());
        log.info("2. AddTraceIdFilter before");
        chain.doFilter(request, response);
        log.info("2. AddTraceIdFilter After");
    }

    @Override
    public void destroy() {
        log.info("2. AddTraceIdFilter destroy()");
    }
}
