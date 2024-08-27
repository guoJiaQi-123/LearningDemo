package com.itbaizhan.myshiro.realm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itbaizhan.myshiro.domain.Permission;
import com.itbaizhan.myshiro.domain.Users;
import com.itbaizhan.myshiro.mapper.UsersMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//自定义realm
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UsersMapper usersMapper;

    //自定义认证信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.获取前端传来的用户名
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        //2.根据用户名从数据库中查询用户
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);//定义查询信息
        Users users = usersMapper.selectOne(queryWrapper);
        //3.将查询到的用户名和密码封装为身份信息
        if (users == null) {
            throw new UnknownAccountException("账户不存在");
        }
        /**
         * 参数1：从数据库查询出来的users对象
         * 参数2：查询出的用户密码
         * 参数3：盐
         * 参数4：realm名字
         */
        return new SimpleAuthenticationInfo(users,
                users.getPassword(),
                ByteSource.Util.bytes(users.getSalt()),
                "myRealm");
    }

    //自定义授权信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权。。。。");
        //1.获取用户认证信息
        Users users = (Users) principalCollection.getPrimaryPrincipal();
        //2.根据用户id查询用户权限
        List<Permission> permissions = usersMapper.findPermissionByUserId(users.getUid());
        //3.将查询到的用户权限交给shiro管理（封装到AuthorizationInfo对象中并返回即可）
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (Permission permission : permissions) {
            simpleAuthorizationInfo.addStringPermission(permission.getUrl());
        }
        return simpleAuthorizationInfo;
    }
}
