package com.itbaizhan.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version v1.0
 * @author OldGj 2024/4/29
 * @apiNote 商品控制层
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {


    /**
     * 热点key限流
     * @param goodsName 商品名称
     * @return
     */
    @SentinelResource("hot")
    @GetMapping("/getGoods")
    public String getGoods(String goodsName) {
        return goodsName;
    }


}
