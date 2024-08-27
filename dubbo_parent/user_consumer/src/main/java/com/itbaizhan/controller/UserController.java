package com.itbaizhan.controller;

import com.itbaizhan.User;
import com.itbaizhan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    public String addUser(User user){
        userService.addUser(user);
        return "redirect:/ok";
    }

    @RequestMapping("/showUser")
    public ModelAndView showUser(){
        ModelAndView modelAndView = new ModelAndView();
        List<User> allUser = userService.findAllUser();
        modelAndView.addObject("allUser",allUser);
        modelAndView.setViewName("/showUser");
        return modelAndView;
    }

    @RequestMapping("/edit")
    public ModelAndView edit(Long userId){
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.preUpdateUsers(userId);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("/updateUser");
        return modelAndView;
    }

    @RequestMapping("/update")
    public String update(User user){
        userService.updateUser(user);
        return "redirect:/user/showUser";
    }

    @RequestMapping("/delete")
    public String delete(Long userId){
        userService.deleteUserById(userId);
        return "redirect:/user/showUser";
    }

}
