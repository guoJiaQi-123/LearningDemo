package com.itbaizhan.travel.utils;

import com.itbaizhan.travel.util.MailUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MailUtilsTest {
    @Autowired
    private MailUtils mailUtils;

    @Test
    void testSendMail(){
        mailUtils.sendMail("2667629684@qq.com","这是一封测试邮件","测试");
    }
}
