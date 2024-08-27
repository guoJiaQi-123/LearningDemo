package com.itbaizhan.springbootdemo1.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class SecondFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入second filter");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("离开second filter");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
