package com.estsoft.blogjpa.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class UrlPrintFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("1. url print filter init() - {}", filterConfig.getFilterName());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        log.info("1. UrlPrintFilter {}", httpServletRequest.getRequestURL().toString());

        log.info("1. UrlPrintFilter before");
        chain.doFilter(request, response);
        log.info("1. UrlPrintFilter After");
    }

    @Override
    public void destroy() {
        log.info("1. url print filter destroy");
    }
}
