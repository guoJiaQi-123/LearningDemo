package com.itbaizhan.springbootdemo1.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(urlPatterns = "/first")
public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入first servlet");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("离开first servlet");
    }

    @Override
    public void destroy() {
    }
}
