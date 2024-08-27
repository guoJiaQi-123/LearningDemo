package com.tyut.test.mapper;

import com.tyut.test.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @version v1.0
 * @apiNote 用户持久层
 * @author OldGj 2024/5/7
 */
@Mapper
public interface UserMapper {


    @Select("select  * from user where id = #{id}")
    User selectById(Integer id);
}
