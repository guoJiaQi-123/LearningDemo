package com.itbaizhan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version v1.0
 * @author OldGj 2024/5/4
 * @apiNote java 探针控制层
 */
@RestController
public class AgentController {

    @GetMapping("/hello")
    public String hello() {
        return "hello agent";
    }

}
