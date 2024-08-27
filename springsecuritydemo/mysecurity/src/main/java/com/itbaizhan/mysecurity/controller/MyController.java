package com.itbaizhan.mysecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("/users/username")
    public String getUsername() {
        // 1.获取会话对象
        SecurityContext securityContext = SecurityContextHolder.getContext();
        // 2.获取认证对象
        Authentication authentication = securityContext.getAuthentication();
        // 3.获取登录用户信息
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userDetails.getUsername();
    }


    @PreAuthorize("hasAnyAuthority('/reportform/find')")//配置权限，当有/reportform/find权限时，才能访问该资源
    @GetMapping("/reportform/find")
    public String findReportForm() {
        return "查询报表";
    }

    @PreAuthorize("hasAnyAuthority('/salary/find')")//配置权限，当有/reportform/find权限时，才能访问该资源
    @GetMapping("/salary/find")
    public String findSalary() {
        return "查询工资";
    }

    @PreAuthorize("hasAnyAuthority('/staff/find')")//配置权限，当有/reportform/find权限时，才能访问该资源
    @GetMapping("/staff/find")
    public String findStaff() {
        return "查询员工";
    }

}
