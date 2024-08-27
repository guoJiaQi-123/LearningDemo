package com.itbaizhan.travel.service;

import com.itbaizhan.travel.bean.PermissionWithStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RoleServiceTest {
    @Autowired
    private RoleService roleService;


    @Test
    void testPermissionWithStatuses(){
        List<PermissionWithStatus> permissionWithStatusList = roleService.permissionWithStatuses(1);
        System.out.println(permissionWithStatusList);
    }
}
