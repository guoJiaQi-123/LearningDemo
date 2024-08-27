package com.tyutgjq.test;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

public class RedisTest {

    Jedis jedis;

    @Before
    public void init() {
        jedis = new Jedis("192.168.66.150", 6379);
    }


    /**
     * 清理所有缓存
     */
    @Test
    public void flushAll(){
        jedis.flushAll();
    }

    /**
     * String操作
     */
    @Test
    public void testString(){
//        jedis.flushAll();
        // 添加string类型缓存
        jedis.set("k1","v1");
        // 获取String类型缓存
        String s = jedis.get("k1");
        System.out.println(s);
    }

    /**
     * list操作
     */
    @Test
    public void testList(){
        jedis.lpush("k1","v1","v2","v3");
        jedis.rpush("k1","v1","v2","v3");

        List<String> k1 = jedis.lrange("k1", 0, -1);
        for (String s : k1) {
            System.out.println(s);
        }
    }

    /**
     * set操作
     */
    @Test
    public void testSet(){
        //添加set类型数据
        jedis.sadd("k1","v1","v2","v2","v1","v3");
        //获取set类型数据
        Set<String> k1 = jedis.smembers("k1");
        for (String s : k1) {
            System.out.println(s);
        }
    }

    /**
     * hash操作
     */
    @Test
    public void testHash(){
        //添加hash数据
        jedis.hset("user","age","20");
        jedis.hset("user","name","guojiaqi");

        //获取hash数据
        String s1 = jedis.hget("user", "age");
        System.out.println(s1);
        Set<String> user = jedis.hkeys("user");
        for (String s : user) {
            System.out.println(s);
        }
        List<String> user1 = jedis.hvals("user");
        for (String s : user1) {
            System.out.println(s);
        }
    }











    @After
    public void close(){
        jedis.close();
    }

}
