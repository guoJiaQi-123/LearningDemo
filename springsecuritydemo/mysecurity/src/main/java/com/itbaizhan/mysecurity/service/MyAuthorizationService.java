package com.itbaizhan.mysecurity.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

//自定义权限拦截（只有用户拥有与访问资源同名的权限时，才能够访问该资源）
@Service
public class MyAuthorizationService {

    public boolean hasPermission(HttpServletRequest request, Authentication authentication){
        //获取会话中的登录用户
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        //获取登录用户的所有权限
        Collection<? extends GrantedAuthority> allAuthorities = userDetails.getAuthorities();
        //获取请求的URL路径
        String requestURI = request.getRequestURI();
        //将请求的URL封装为security自带权限对象
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(requestURI);
        //判断请求的URL封装的权限对象 是否 在用户的权限集合中
        return allAuthorities.contains(grantedAuthority);
    }

}
