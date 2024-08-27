package com.tyut.aircraft.security;

import com.tyut.aircraft.service.UserService;
import com.tyut.aircraft.util.BaseContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


//自定义认证逻辑
@Service
@SuppressWarnings("all")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserService userService;

    /**
     * 自定义认证逻辑
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //1.认证
        //根据用户在前端表单输入的用户名从数据库中查询到该用户
        com.tyut.aircraft.pojo.domain.User user = userService.findUserByUsername(username);
        // 如果用户不存在，抛出异常，认证失败，跳转到自定义认证失败页面
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        // 如果用户状态为FALSE 抛出异常，认证失败，跳转到自定义认证失败页面
        if (!user.isActive()) {
            throw new UsernameNotFoundException("用户不可用");
        }


        //2.授权
//        List<Permission> permissions = userService.findPermission(username);
//        //将自己的权限对象转换为springSecurity框架定义的GrantedAuthority对象
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//        for (Permission permission : permissions) {
//            grantedAuthorities.add(new SimpleGrantedAuthority(permission.getPermissionDesc()));
//        }

        //3.将用户信息封装为UserDetails对象
        //如果用户存在，则将用户信息封装到userDetails对象当中，springSecurity框架会自动将用户信息与前端表单中的信息做认证
        UserDetails userDetails = User.withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(grantedAuthorities)
                .build();
        //返回UserDetails对象
        BaseContext.setCurrentName(user.getUsername());
        return userDetails;
    }
}
