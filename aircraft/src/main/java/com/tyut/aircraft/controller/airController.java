package com.tyut.aircraft.controller;

import com.tyut.aircraft.service.GameService;
import com.tyut.aircraft.service.MyGameFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version v1.0
 * @author OldGj 2024/6/21
 * @apiNote 控制器
 */
@Controller
@RequestMapping("/aircraft")
public class airController {


    @Autowired
    private GameService gameService;


    /**
     * 开始游戏
     */
    @PostMapping("/startGame")
    public String startGame(Authentication authentication, String diff) {
        String name = authentication.getName();
        gameService.startGame(name, diff);
        return "redirect:/air/index";
    }




}
