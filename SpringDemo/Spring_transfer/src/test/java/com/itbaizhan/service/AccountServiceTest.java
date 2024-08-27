package com.itbaizhan.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)// JUnit使用Spring方式运行代码，即自动创建spring容器。
// 配置类写法：@ContextConfiguration(classes=配置类.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")// 告知创建spring容器时读取哪个配置类或配置文件
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testTransfer(){
        accountService.transfer(2,1,500);
    }

}
