package com.itbaizhan.mapper;

import com.itbaizhan.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import javax.xml.ws.BindingType;
import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    List<User> findAllUser();

    @SelectKey(keyProperty = "id" ,keyColumn = "id",
            resultType = int.class,statement = "SELECT LAST_INSERT_ID()",before = false)
    @Insert("insert into user(username,sex,address) values (#{username},#{sex},#{address})")
    void add(User user);


}
