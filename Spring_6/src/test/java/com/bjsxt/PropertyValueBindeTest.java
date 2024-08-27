package com.bjsxt;

import com.bjsxt.DataBinder.Person;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.validation.DataBinder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PropertyValueBindeTest {

    @Test
    void test(){
        //创建一个属性绑定的类型PropertyValues,并设置值
        Map<String,Object> map = new HashMap<>();
        map.put("id",1);
        map.put("name","guojiaqi1");
        MutablePropertyValues propertyValues = new MutablePropertyValues(map);
        //创建数据绑定对象DataBinder   参数：给那个对象进行数据绑定
        Person person = new Person();
        DataBinder dataBinder = new DataBinder(person);

        //调用bind方法进行数据绑定
        dataBinder.bind(propertyValues);
        System.out.println(person);
    }

    @Test
    void test2(){
        //创建一个属性绑定的类型PropertyValues,并设置值
        List<PropertyValue> list = new ArrayList<>();
        PropertyValue id = new PropertyValue("id", 2);
        PropertyValue name = new PropertyValue("name", "郭家旗2");
        list.add(id);
        list.add(name);
        MutablePropertyValues propertyValues = new MutablePropertyValues(list);

        //创建数据绑定对象DataBinder   参数：给那个对象进行数据绑定
        Person person = new Person();
        DataBinder dataBinder = new DataBinder(person);
        //调用bind方法进行数据绑定
        dataBinder.bind(propertyValues);
        System.out.println(person);
    }

    @Test
    void test3(){
        //创建一个属性绑定的类型PropertyValues,并设置值
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue("name","guojiaqi3");
        propertyValues.addPropertyValue(new PropertyValue("id",3));

        //创建数据绑定对象DataBinder   参数：给那个对象进行数据绑定
        Person person = new Person();
        DataBinder dataBinder = new DataBinder(person);
        //调用bind方法进行数据绑定
        dataBinder.bind(propertyValues);
        System.out.println(person);
    }

    @Test
    void test4(){
        //创建一个属性绑定的类型PropertyValues,并设置值
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        Map<String,Object> map = new HashMap<>();
        map.put("name","guojiaqi4");
        map.put("id","4");
        propertyValues.addPropertyValues(map);

        //创建数据绑定对象DataBinder   参数：给那个对象进行数据绑定
        Person person = new Person();
        DataBinder dataBinder = new DataBinder(person);
        //调用bind方法进行数据绑定
        dataBinder.bind(propertyValues);
        System.out.println(person);
    }

    @Test
    void test5(){
        int i=90;
        String s = i+"";
        int length = s.length();
        System.out.println(s);
    }
}
