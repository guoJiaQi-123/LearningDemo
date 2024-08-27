package com.itbaizhan.myshiro.realm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itbaizhan.myshiro.domain.Admin;
import com.itbaizhan.myshiro.domain.Users;
import com.itbaizhan.myshiro.mapper.AdminMapper;
import com.itbaizhan.myshiro.mapper.UsersMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

//自定义realm
public class MyRealm2 extends AuthorizingRealm {

    @Autowired
    private AdminMapper adminMapper;

    //自定义认证信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.获取前端传来的用户名
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        //2.根据用户名从数据库中查询用户
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", username);//定义查询信息
        Admin admin = adminMapper.selectOne(queryWrapper);
        //3.将查询到的用户名和密码封装为身份信息
        if (admin == null) {
            throw new UnknownAccountException("账户不存在");
        }
        /**
         * 参数1：从数据库查询出来的users对象
         * 参数2：查询出的用户密码
         * 参数3：realm名字
         */
        return new SimpleAuthenticationInfo(admin,admin.getPassword(),"myRealm2");
    }

    //自定义授权信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
