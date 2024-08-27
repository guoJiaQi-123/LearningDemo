package com.itbaizhan.controller;

import com.itbaizhan.IUserService;
import com.itbaizhan.common.CommonResult;
import com.itbaizhan.entity.User;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/04/24
 * @apiNote 用户控制层
 */
@Controller
@RequestMapping("/user")
public class UserController {


    @DubboReference
    private IUserService userService;


    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping("/addUser")
    public String addUser(User user) {
        CommonResult<?> commonResult = userService.insertUser(user);
        if (commonResult.getCode() == 200) {
            return "redirect:/ok";
        } else {
            return "redirect:/error";
        }
    }

    /**
     * 查询用户
     * @return
     */
    @GetMapping("/showUser")
    public ModelAndView showUser() {
        CommonResult<List<User>> listCommonResult = userService.selectUser(new User());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users", listCommonResult.getDate());
        modelAndView.setViewName("showUser");
        return modelAndView;
    }

    /**
     * 更新用户 - 将用户数据回显
     * @param id
     * @return
     */
    @GetMapping("/updateUser")
    public ModelAndView updateUser(Long id) {
        User user = new User();
        user.setId(id);
        CommonResult<List<User>> listCommonResult = userService.selectUser(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", listCommonResult.getDate().get(0));
        modelAndView.setViewName("updateUser");
        return modelAndView;
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @PostMapping("/toUpdateUser")
    public String toUpdateUser(User user) {
        CommonResult<?> commonResult = userService.updateUser(user);
        if (commonResult.getCode() == 200) {
            return "redirect:/user/showUser";
        } else {
            return "redirect:/error";
        }
    }

    /**
     * 通过用户ID删除用户
     * @param id 用户ID
     * @return
     */
    @GetMapping("/deleteUser")
    public String deleteUser(Integer id) {
        User user = new User();
        CommonResult<?> commonResult = userService.deleteUser(id);
        if (commonResult.getCode() == 200) {
            return "redirect:/user/showUser";
        } else {
            return "redirect:/error";
        }
    }
}
