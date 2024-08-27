package com.itbaizhan.myshiro;

import org.apache.shiro.crypto.hash.Md2Hash;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Testmd5 {

    @Test
    void test(){
        Md5Hash md5Hash = new Md5Hash("123","sxt",5);
        System.out.println(md5Hash);
    }
}
