package com.tyutgjq.web_cache.service;

import com.alibaba.fastjson.JSON;
import com.tyutgjq.web_cache.entity.GoodsEntity;
import com.tyutgjq.web_cache.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class GoodsService {


    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 根据id查询
     */
    public GoodsEntity getId(Long id) {
        /**
         * 使用Redis缓冲  10000并发 qps:7000+
         */
        // 1.从缓存中获取数据
        String string = stringRedisTemplate.opsForValue().get("goods:" + id);
        if (string.isEmpty()) {
            //没有缓存 从数据库中查询数据
            Optional<GoodsEntity> optionalGoodsEntity = goodsRepository.findById(id);
            GoodsEntity goodsEntity = optionalGoodsEntity.get();
            //将数据转换为JSON字符串保存到缓存当中
            String jsonString = JSON.toJSONString(goodsEntity);
            stringRedisTemplate.opsForValue().set("goods:" + id, jsonString);
            return goodsEntity;
        } else {
            //有缓存   从Redis缓存中获取JSON字符串转换为对象返回
            GoodsEntity goodsEntity = JSON.parseObject(string, GoodsEntity.class);
            return goodsEntity;
        }

        /**
         * 不使用Redis缓冲  10000并发 qps:1000+
         */
        /*
        Optional<GoodsEntity> optionalGoodsEntity = goodsRepository.findById(id);
        GoodsEntity goodsEntity = optionalGoodsEntity.get();
        return goodsEntity;

         */
    }

}
