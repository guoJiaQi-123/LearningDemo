package com.tyut.aircraft.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tyut.aircraft.pojo.domain.Game;
import com.tyut.aircraft.pojo.domain.User;
import com.tyut.aircraft.service.GameService;
import com.tyut.aircraft.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/6/24
 * @apiNote TODO(一句话给出该类描述)
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private GameService gameService;

    /**
     * 用户注册
     * @param user 前端传来的用户信息
     * @return
     */
    @PostMapping("/register")
    public String register(User user) {
        log.info("用户注册：{}", user);
        userService.register(user);
        return "redirect:/air/user_login";
    }


    String name = "";

    @RequestMapping("/history")
    public ModelAndView findPage(@RequestParam(defaultValue = "1") int page,
                                 @RequestParam(defaultValue = "13") int size,
                                 HttpServletRequest request) {
        if (StringUtils.hasText((String) request.getAttribute("name"))) {
            name = (String) request.getAttribute("name");
        }
        Page<Game> gamePage = gameService.findGamePage(name, page, size);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("gamePage", gamePage);
        modelAndView.setViewName("/air/user_history");
        return modelAndView;
    }

    @RequestMapping("/delete")
    public String delete(Integer gid) {
        gameService.deleteGame(gid);
        return "redirect:/air/user_history";
    }
}
