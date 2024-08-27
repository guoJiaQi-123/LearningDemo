package com.itbaizhan.sercice;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.itbaizhan.IUserService;
import com.itbaizhan.common.CommonResult;
import com.itbaizhan.entity.User;
import com.itbaizhan.mapper.UserMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/04/24
 * @apiNote 用户业务层实现类
 */
@DubboService
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 新增用户
     * @param user 新增的用户
     * @return 新增成功，返回ID
     */
    @Override
    public CommonResult<?> insertUser(User user) {
        int inserted = userMapper.insert(user);
        if (inserted > 0) {
            return new CommonResult<>(200, "SUCCESS", inserted);
        } else {
            return new CommonResult<>(500, "系统异常");
        }
    }

    /**
     * 查询用户
     * @param user 用户实体类-封装了具体需要查询的属性
     * @return 查询到的用户
     */
    @Override
    public CommonResult<List<User>> selectUser(User user) {
        // 1、条件构造器
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(user.getId() != null, User::getId, user.getId());
        lambdaQueryWrapper.eq(user.getName() != null, User::getName, user.getName());
        lambdaQueryWrapper.eq(user.getAge() != null, User::getAge, user.getAge());
        // 2、查询用户
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        // 3、返回结果
        return new CommonResult<>(200, "SUCCESS", users);
    }

    /**
     * 更新用户
     * @param user 用户实体类-封装了具体需要更新的属性
     * @return
     */
    @Override
    public CommonResult<?> updateUser(User user) {
        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.set(user.getAge() != null, User::getAge, user.getAge());
        lambdaUpdateWrapper.set(user.getName() != null, User::getName, user.getName());
        if (user.getId() == null) {
            return new CommonResult(500, "用户id为空~");
        }
        lambdaUpdateWrapper.eq(User::getId, user.getId());
        int updated = userMapper.update(null, lambdaUpdateWrapper);
        if (updated > 0) {
            return new CommonResult(200, "SUCCESS");
        } else {
            return new CommonResult(500, "更新失败");
        }
    }

    /**
     * 根据用户ID删除用户
     * @param id 用户ID
     * @return
     */
    @Override
    public CommonResult deleteUser(Integer id) {
        if (id == null) {
            return new CommonResult(500, "用户id为空~");
        }
        // 1、根据用户id删除用户
        int deleteById = userMapper.deleteById(id);
        if (deleteById > 0) {
            return new CommonResult(200, "SUCCESS");
        } else {
            return new CommonResult(500, "删除失败");
        }
    }


}
