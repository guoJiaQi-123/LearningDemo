package com.itbaizhan.myshiro.controller;

import com.itbaizhan.myshiro.domain.Admin;
import com.itbaizhan.myshiro.domain.Users;
import com.itbaizhan.myshiro.service.UsersService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;

@Controller
public class LoginController {

    @Autowired
    private UsersService usersService;

    /*
     * 使用配置文件作为数据源实现登录认证
     * */
    @SuppressWarnings("all")
    @RequestMapping("/user/login")
    public String login(String username, String password) {
        //1.获取SecurityManager工厂，读取配置文件
        IniSecurityManagerFactory securityManagerFactory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //2.获取SecurityManager对象
        SecurityManager securityManager = securityManagerFactory.getInstance();
        //3.将SecurityManager对象放入运行环境中去
        SecurityUtils.setSecurityManager(securityManager);
        //4.获取subject对象
        Subject subject = SecurityUtils.getSubject();
        //5.将前端传来的用户名密码封装为shiro提供的一个身份对象
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            //6.进行shiro认证
            subject.login(token);
            //7.设置认证成功后的跳转页面
            return "main";
        } catch (AuthenticationException e) {
            //8.设置认证失败后的跳转页面
            return "fail";
        }
    }

    /*
     * 使用数据库作为数据源实现登录认证（实际开发）
     * */
    @SuppressWarnings("all")
    @RequestMapping("/user/login2")
    public String login2(String username, String password,String rememberMe) {
        try {
            usersService.userLogin(username, password,rememberMe);
            return "main";
        } catch (DisabledAccountException e) {
            System.out.println("账户失效");
            return "fail";
        } catch (ConcurrentAccessException e) {
            System.out.println("竞争次数过多");
            return "fail";
        } catch (ExcessiveAttemptsException e) {
            System.out.println("尝试次数过多");
            return "fail";
        } catch (UnknownAccountException e) {
            System.out.println("用户名或密码不正确");
            return "fail";
        } catch (IncorrectCredentialsException e) {
            System.out.println("用户名或密码不正确");
            return "fail";
        } catch (ExpiredCredentialsException e) {
            System.out.println("凭证过期");
            return "fail";
        }catch (AuthenticationException e) {
            System.out.println("登录失败");
            return "fail";
        }
    }

    @RequestMapping("/user/getusername")
    @ResponseBody
    public String getUserName(){
        Subject subject = SecurityUtils.getSubject();
        Users users = (Users) subject.getPrincipal();
        return users.getUsername();

    }

    @RequestMapping("/user/pay")
    @ResponseBody
    public String pay(){
        return "支付功能";
    }
}
