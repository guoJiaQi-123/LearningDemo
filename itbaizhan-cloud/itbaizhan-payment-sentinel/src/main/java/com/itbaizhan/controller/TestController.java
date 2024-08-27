package com.itbaizhan.controller;

import com.itbaizhan.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version v1.0
 * @author OldGj 2024/4/29
 * @apiNote 测试控制层
 */
@RestController
public class TestController {


    @Autowired
    private GoodsService goodsService;

    @GetMapping("/test")
    public String test() {
        return "hello sentinel";
    }

    @GetMapping("/query")
    public String query() {
        goodsService.queryGoods();
        return "query";
    }

    @GetMapping("/update")
    public String update() {
        goodsService.queryGoods();
        return "update";
    }

    @GetMapping("/warmup")
    public String warmup() {
        return "warmup";
    }
}
