package com.itbaizhan;

import com.itbaizhan.common.CommonResult;
import com.itbaizhan.entity.User;

import java.util.List;

/**
 * @version v1.0
 * @apiNote 用户业务层接口
 * @author OldGj 2024/04/24
 */
public interface IUserService {

    /**
     * 新增用户
     * @param user 新增的用户
     * @return 新增成功，返回ID
     */
    CommonResult<?> insertUser(User user);

    /**
     * 查询用户
     * @param user 用户实体类-封装了具体需要查询的属性
     * @return 查询到的用户
     */
    CommonResult<List<User>> selectUser(User user);

    /**
     * 更新用户
     * @param user 用户实体类-封装了具体需要更新的属性
     * @return
     */
    CommonResult updateUser(User user);

    /**
     * 根据用户ID删除用户
     * @param id 用户ID
     * @return
     */
    CommonResult deleteUser(Integer id);

}
