package com.bjsxt.DataBinder;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.validation.DataBinder;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {


        //创建一个属性绑定的类型PropertyValues,并设置值
        Map<String,Object> map = new HashMap<>();
        map.put("id","1");
        map.put("name","郭家旗");
        PropertyValues propertyValues= new MutablePropertyValues(map);

        //实例化DataBinder
        Person person = new Person();
        DataBinder dataBinder = new DataBinder(person,"随便");//随便起个名
        //数据绑定
        dataBinder.bind(propertyValues);
        //查看绑定后的结果
        System.out.println(person);
    }
}
