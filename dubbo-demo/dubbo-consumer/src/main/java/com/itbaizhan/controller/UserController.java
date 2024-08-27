package com.itbaizhan.controller;

import com.itbaizhan.pojo.CommonResult;
import com.itbaizhan.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    private IUserService iUserService;

    @GetMapping("/findUserById")
    public CommonResult findUserByUserId(long userId) {
        return iUserService.findByUserId(userId);
    }
}
