package com.itbaizhan;

import com.itbaizhan.service.UserService;

public class Test {
    public static void main(String[] args) {
        UserService userService = (UserService) Container.getBean("UserService");
        userService.findUserById();
    }
}
