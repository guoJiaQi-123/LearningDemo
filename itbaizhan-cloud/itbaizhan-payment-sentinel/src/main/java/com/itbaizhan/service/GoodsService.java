package com.itbaizhan.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @version v1.0
 * @author OldGj 2024/4/29
 * @apiNote 商品业务层
 */
@Service
public class GoodsService {

    @SentinelResource("/good")
    public void queryGoods(){
        System.err.println("查询商品");
    }

}
