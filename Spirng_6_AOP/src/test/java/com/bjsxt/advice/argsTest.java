package com.bjsxt.advice;

import com.bjsxt.service.PeopleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@ContextConfiguration(locations = "classpath:applicationContext-args.xml")
public class argsTest {

    @Autowired
    PeopleService peopleService;

    @Test
    void test(){
        peopleService.insert("郭家旗",16);
    }
}
