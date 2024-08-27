package com.itbaizhan.mapper;

import com.itbaizhan.pojo.PageQueryParams;
import com.itbaizhan.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper2 {
   //动态查询
    List<User> findUserByCondition(User user);

    //动态更新
    void updateUser(User user);

    /*
    * 根据用户名查询
    * 如果用户名长度在0-5之间，采用模糊查询
    * 如果用户长度在5-10之间。采用精确查询
    * 如果用户长度大于10，之间返回ID为1的用户
    * */
    List<User> findUserByUsername(String username);


    //批量删除
    void deleteBatch(int[] ids);

    //批量添加
    void addBatch(List<User> userList);

    //多条件查询
    List<User> findUser(@Param("queryMap") Map<String,Object> map);
}
