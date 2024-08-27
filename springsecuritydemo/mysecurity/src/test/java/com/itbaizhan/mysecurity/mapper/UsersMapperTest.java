package com.itbaizhan.mysecurity.mapper;

import com.itbaizhan.mysecurity.domain.Permission;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UsersMapperTest {
    @Autowired
    private UsersMapper usersMapper;

    @Test
    void testFindPermissionByUsersName(){
        List<Permission> baizhan = usersMapper.findPermissionByUserName("baizhan");
        baizhan.forEach(System.out::println);
    }
}
