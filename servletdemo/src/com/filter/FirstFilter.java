package com.filter;

import javax.servlet.*;
import java.io.IOException;

public class FirstFilter implements Filter {
    /**
     * 初始化方法，在创建Filter后立即调用。可用于完成初始化动作。
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init-----");
    }


    /**
     * 拦截请求与响应方法，可用于对请求和响应实现预处理。
     * 当客户端所请求的URL和Filter中定义的URL-Pattern所匹配，那么该请求会被Filter所拦截
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //对请求做过滤
        System.out.println("请求被过滤");
        //对过滤后的请求放行
        filterChain.doFilter(servletRequest,servletResponse);

        //对响应做过滤
        System.out.println("响应被过滤");
    }
    /**
     *  销毁方法，在销毁Filter之前自动调用。可用于完成资源释放等动作。
     */
    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
