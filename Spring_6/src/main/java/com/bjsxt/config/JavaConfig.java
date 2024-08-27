package com.bjsxt.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// 专门用在Java Config的注解。@Component的子注解。用它语义更强
@Configuration
public class JavaConfig {
    // @Bean的value属性是指定Bean的名称。如果没有指定，方法名为Bean的名称
    @Bean
    /*
      访问权限修饰符：只要不是private就可以。default/protected/public都可以。
      返回值类型：配置后Bean的类型。相当于<bean>中的class
      方法名：配置后Bean的名称。相当于<bean>中的id。
      参数：只要写，Spring会自动注入。
   */
    public Student student(Teacher teacher){// 默认按照byType自动注入
        Student student = new Student();
        student.setId(1);
        student.setName("郭家旗");
        student.setTeacher(teacher);
        return student;
    }

    @Bean
    public Teacher teacher(){
        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setName("666");
        return teacher;
    }

}
