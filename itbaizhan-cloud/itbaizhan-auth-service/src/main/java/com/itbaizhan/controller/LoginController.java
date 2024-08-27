package com.itbaizhan.controller;

import com.itbaizhan.domain.BaseResult;
import com.itbaizhan.domain.UserDTO;
import com.itbaizhan.service.ILoginService;
import org.jose4j.lang.JoseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version v1.0
 * @author OldGj 2024/4/28
 * @apiNote 登录控制层
 */
@RestController
public class LoginController {

    private final ILoginService loginService; //登录接口

    @Autowired
    public LoginController(ILoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public BaseResult login(@RequestBody UserDTO userDTO) throws JoseException {
        return loginService.login(userDTO);
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
