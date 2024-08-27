package com.itbaizhan.service.impl;

import com.itbaizhan.domain.BaseResult;
import com.itbaizhan.domain.UserDTO;
import com.itbaizhan.service.ILoginService;
import com.itbaizhan.util.JWTUtils;
import io.micrometer.common.util.StringUtils;
import org.jose4j.lang.JoseException;
import org.springframework.stereotype.Service;

/**
 * @version v1.0
 * @author OldGj 2024/4/28
 * @apiNote 登录接口实现类
 */
@Service
public class LoginServiceImpl implements ILoginService {
    @Override
    public BaseResult login(UserDTO userDTO) throws JoseException {
        // 1、用户名或者密码校验
        if (StringUtils.isEmpty(userDTO.getUsername()) || StringUtils.isEmpty(userDTO.getPassword())) {
            return BaseResult.fail("用户名或密码为空");
        } else {
            // todo 数据库操作
            // 2、判断用户名和密码是否正确
            if (userDTO.getUsername().equals("admin") && userDTO.getPassword().equals("123456")) {
                // 用户名和密码正确，办法令牌token
                String token = JWTUtils.sign(1001L, "admin");
                return BaseResult.ok(token);
            } else {
                return BaseResult.fail("用户名或密码错误");
            }
        }
    }
}
