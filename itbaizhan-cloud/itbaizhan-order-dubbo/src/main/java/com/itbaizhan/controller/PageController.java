package com.itbaizhan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version v1.0
 * @author OldGj 2024/04/24
 * @apiNote 视图控制器
 */
@Controller
public class PageController {

    /**
     * 视图跳转控制器
     * @param page 跳转页面
     * @return
     */
    @GetMapping("/{page}")
    public String toPage(@PathVariable String page) {
        return page;
    }

    // 忽略访问项目logo
    @RequestMapping("/favicon.ico")
    @ResponseBody
    void returnNoFavicon() {
    }
}
