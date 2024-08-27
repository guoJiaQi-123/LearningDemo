package com.bjsxt;

import com.bjsxt.pojo.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@ContextConfiguration("classpath:rw.xml")
public class ResourceLoaderAwareTest {

    @Autowired
    Teacher teacher;

    @Test
    void test(){
        System.out.println(teacher);
    }

}
