package com.bjsxt.web.filter;

import com.bjsxt.commons.Constants;
import com.bjsxt.pojo.Users;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 判断当前客户端是否登录的filter
 */
@WebFilter(urlPatterns = {"*.do","*.jsp"})
public class UserLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestURI = request.getRequestURI();
        //判断当前请求的是否为login.jsp或者login.do，如果请求的是登录资源，则放行
        if(requestURI.indexOf("login.jsp")!=-1||requestURI.indexOf("login.do")!=-1||requestURI.indexOf("validateCode.do")!=-1){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            HttpSession httpSession = ((HttpServletRequest) servletRequest).getSession();
            Users users = (Users) httpSession.getAttribute(Constants.USER_SESSION_KEY);
            if(users!=null){
                filterChain.doFilter(servletRequest,servletResponse);
            }else {
                request.setAttribute(Constants.REQUEST_MSG,"不登录不好使");
                request.getRequestDispatcher("login.jsp").forward(servletRequest,servletResponse);
            }
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
