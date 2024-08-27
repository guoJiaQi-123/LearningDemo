package com.tyutgjq.springdataredisdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringdataredisdemoApplicationTests {


    @Autowired
    RedisTemplate redisTemplate;


    @Test
    void testString() {
        redisTemplate.opsForValue().set("k1", "v1");
    }


    @Test
    void testHash() {
        redisTemplate.opsForHash().put("user", "age", 20);
        redisTemplate.opsForHash().put("user", "name", "guojiaqi");
    }








}
