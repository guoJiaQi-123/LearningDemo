package com.bjsxt;

import com.bjsxt.config.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@ContextConfiguration("classpath:applicationContext2.xml")
public class MyScopeTest {


    @Autowired
    ApplicationContext applicationContext;

    @Test
    void test(){
        Student student = applicationContext.getBean("student", Student.class);

        new Thread(){
            Student student3 = applicationContext.getBean("student", Student.class);
            @Override
            public void run() {
                System.out.println("子线程"+(student==student3));
            }
        }.start();
        Student student2 = applicationContext.getBean("student", Student.class);

        System.out.println("主线程"+(student==student2));
    }

}
