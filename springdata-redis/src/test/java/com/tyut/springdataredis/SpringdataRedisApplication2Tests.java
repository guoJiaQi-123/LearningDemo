package com.tyut.springdataredis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tyut.springdataredis.redis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class SpringdataRedisApplication2Tests {
    @Autowired
    private StringRedisTemplate stringRedisTemplate; // key和value都是用string序列化器

    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    void name() throws JsonProcessingException {
        User user = new User("郭家旗", 21);
        // 将对象手动转换为json字符串
        String json = mapper.writeValueAsString(user);
        stringRedisTemplate.opsForValue().set("name:200", json);
        String jsonUser = stringRedisTemplate.opsForValue().get("name:200");
        // 将json字符串手动转换为 User 对象
        User user1 = mapper.readValue(jsonUser, User.class);
        System.out.println("user1=" + user1);
    }
}
