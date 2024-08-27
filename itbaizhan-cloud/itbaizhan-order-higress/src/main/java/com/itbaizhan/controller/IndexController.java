package com.itbaizhan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version v1.0
 * @author OldGj 2024/04/25
 * @apiNote 控制器
 */
@RestController
public class IndexController {


    @GetMapping("/index")
    public String index() {
        return "hello higress";
    }
}
