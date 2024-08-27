package com.itbaizhan.myshiro.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private DefaultWebSecurityManager securityManager;

    public void userLogin(String username,String password,String rememberMe) throws AuthenticationException {
        //1.将SecurityManager对象放入运行环境中
        SecurityUtils.setSecurityManager(securityManager);
        //2.将用户名密码封装为shiro提供的身份对象
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        //3.获取subject对象
        Subject subject = SecurityUtils.getSubject();
        //如果用户选择了记住我，则生成记住我的cookie
        if(rememberMe!=null){
            token.setRememberMe(true);
        }
        //4.shiro认证
        subject.login(token);
    }
}
