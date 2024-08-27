package com.itbaizhan.service;

import com.itbaizhan.domain.BaseResult;
import com.itbaizhan.domain.UserDTO;
import org.jose4j.lang.JoseException;

/**
 * @version v1.0
 * @author OldGj 2024/4/28
 * @apiNote 登录业务层
 */
public interface ILoginService {

    // 登录接口
    BaseResult login(UserDTO userDTO) throws JoseException;

}
