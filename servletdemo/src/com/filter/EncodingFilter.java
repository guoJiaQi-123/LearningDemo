package com.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    String defaultCode = "utf-8";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String code = filterConfig.getInitParameter("code");
        if(code != null && ! code.isEmpty()){
            defaultCode=code;
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //设置请求编码
        servletRequest.setCharacterEncoding(this.defaultCode);
        filterChain.doFilter(servletRequest,servletResponse);

    }
}
