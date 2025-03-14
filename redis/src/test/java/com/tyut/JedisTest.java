package com.tyut;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

/**
 * @version v1.0
 * @author OldGj 2025/3/14
 * @apiNote Jedis客户端测试
 */
public class JedisTest {

    private Jedis jedis;

    @BeforeEach
    void setUp() {
        // 1）建立连接
        jedis = new Jedis("192.168.66.100", 6379);
        // 2）认证密码
        jedis.auth("123456");
        // 3）选择数据库
        jedis.select(0);
    }

    @Test
    void jedis() {
//        jedis.set("name", "jiaqi.guo1");
        String name = jedis.get("name");
        System.out.println(name);
    }

    @Test
    void name() {
        jedis.set("name", "王哥");
        String name = jedis.get("name");
    }

    @AfterEach
    void tearDown() {
        if (jedis != null) {
            jedis.close();
        }
    }
}
