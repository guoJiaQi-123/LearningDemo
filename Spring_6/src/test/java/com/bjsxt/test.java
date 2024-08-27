package com.bjsxt;

import com.bjsxt.config.Student;
import com.bjsxt.pojo.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class test {


    @Test
    void testBeanFactory(){
        // 1. 先实例化化DefaultListableBeanFactory对象   !接收对象时不要使用BeanFactory
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        // 2. 实例化XmlBeanDefinitionReader对象负责加载XML配置文件
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        // 3. 实例化FileSystemResource对象通过Spring配置文件的绝对路径去生成Resource对象
        FileSystemResource resource = new FileSystemResource("C:\\Users\\HX\\IdeaProjects\\Spring_6\\src\\main\\resources\\applicationContext.xml");
        // 4. 将读取到的resource传入XmlBeanDefinitionReader中
        reader.loadBeanDefinitions(resource);
        // 5. 获取Spring容器中的bean对象
        Person person = factory.getBean("person", Person.class);
        System.out.println(person);

    }

    @Test
    void testApplicationContext(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = ac.getBean("person", Person.class);
        System.out.println(person);
    }

    @Test
    @DisplayName("测试util命名空间")
    void test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = ac.getBean("peo2", Person.class);
        System.out.println(person);
    }

    @Test
    @DisplayName("测试lombok效果")
    void test1(){
        com.bjsxt.lombok.Person person = new com.bjsxt.lombok.Person();
        person.equals(1);
        person.hashCode();

        person.setId(1);
        person.getId();
        person.setName("asdasd");
        person.getName();
        System.out.println(person.toString());

    }

    @Test
    @DisplayName("测试@value注解")
    void test3(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext2.xml");
        com.bjsxt.annotation.Person person = ac.getBean("person", com.bjsxt.annotation.Person.class);
        System.out.println(person);
    }

    @Test
    @DisplayName("测试javaConfig")
    void testConfig(){
        ApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext2.xml");
        Student student = ac.getBean("student", Student.class);
        System.out.println(student);
    }
}
