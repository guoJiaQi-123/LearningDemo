package com.bjsxt;


import com.bjsxt.tactics.Animate;
import com.bjsxt.tactics.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@ContextConfiguration("classpath*:**/ac*.xml")
public class ResourceResovler {

    @Autowired
    Animate animate;
    @Autowired
    Teacher teacher;

    @Test
    void test(){
        System.out.println(animate);
        System.out.println(teacher);
    }
}
