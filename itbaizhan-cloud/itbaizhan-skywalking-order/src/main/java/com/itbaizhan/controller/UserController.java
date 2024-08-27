package com.itbaizhan.controller;

import com.itbaizhan.pojo.User;
import com.itbaizhan.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/5/5
 * @apiNote TODO(一句话给出该类描述)
 */
@RestController
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/user/all")
    public Object findAll() throws InterruptedException {
        Thread.sleep(5000);
        List<User> all = iUserService.findAll();
        return all;
    }

}
