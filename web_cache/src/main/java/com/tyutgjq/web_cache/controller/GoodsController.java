package com.tyutgjq.web_cache.controller;


import com.tyutgjq.web_cache.entity.GoodsEntity;
import com.tyutgjq.web_cache.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class GoodsController {


    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/findById")
    public GoodsEntity findById(String id) {
        return goodsService.getId(Long.valueOf(id));
    }
}
