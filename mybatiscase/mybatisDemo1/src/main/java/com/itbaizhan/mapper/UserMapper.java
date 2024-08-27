package com.itbaizhan.mapper;

import com.itbaizhan.pojo.PageQueryParams;
import com.itbaizhan.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface UserMapper {
    //查询方法
    List<User> findAll();

    //新增方法
    void add(User user);

    //更新方法
    void update(User user);

    //删除方法
    void delete(int userId);

    //根据ID查询
    User findUserById(int userid);

    //模糊查询，根据用户名中含有的内容查询
    List<User> findUserByNameLike(String username);

    //分页查询
    List<User> findPage(int startIndex,int pageSize);

    //分页查询2(@param传参  推荐使用)
    List<User> findPage2(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    //分页查询3(将多参数封装到pojo实体类 推荐使用)
    List<User> findPage3(PageQueryParams pageQueryParams);

    //分页查询4(利用Map传参  推荐使用)
    List<User> findPage4(Map<String, Object> map);

    //聚合查询——查询用户数
    int findCount();

    //主键回填
    void add2(User user);
}
