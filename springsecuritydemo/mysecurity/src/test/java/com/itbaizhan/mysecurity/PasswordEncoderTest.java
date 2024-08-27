package com.itbaizhan.mysecurity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.event.annotation.BeforeTestClass;

@SpringBootTest
public class PasswordEncoderTest {

    @Test
    void testPasswordEncoder(){
        //密码解析器
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        //加密后的密码
        String encodePassword = encoder.encode("baizhan");
        System.out.println(encodePassword);

        //密码校验器
        //参数1:明文密码   参数2：加密密码
        boolean result = encoder.matches("baizhan",
                "$2a$10$64kn3mJrRdQdOeZBAg5.hu9Kxi9LdHvVvV3W2Ahajby/BdbbV9msa");
        System.out.println(result);
    }
}
