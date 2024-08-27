package com.tyut.test.controller;

import com.tyut.test.entity.User;
import com.tyut.test.service.IUserService;
import com.tyut.test.service.impl.IUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version v1.0
 * @author OldGj 2024/5/7
 * @apiNote 用户控制层
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/select")
    private User find(Integer id) {
        return userService.findById(id);
    }


}
