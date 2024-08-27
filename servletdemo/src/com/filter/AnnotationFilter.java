package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(urlPatterns = "/*",initParams = {@WebInitParam(name = "key",value = "value")})
public class AnnotationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String key = filterConfig.getInitParameter("key");
        System.out.println(key);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        filterChain.doFilter(servletRequest,servletResponse);
    }
}
