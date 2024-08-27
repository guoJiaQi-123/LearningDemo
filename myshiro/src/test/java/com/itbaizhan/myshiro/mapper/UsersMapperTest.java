package com.itbaizhan.myshiro.mapper;

import com.itbaizhan.myshiro.domain.Permission;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UsersMapperTest {
    @Autowired
    UsersMapper usersMapper;

    @Test
    void testFindPermissionByUserId(){
        List<Permission> permissionByUserId = usersMapper.findPermissionByUserId(1);
        permissionByUserId.forEach(System.out::println);
    }
}
