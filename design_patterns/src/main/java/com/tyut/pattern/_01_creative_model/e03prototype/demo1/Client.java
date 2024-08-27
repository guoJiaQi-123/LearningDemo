package com.tyut.pattern._01_creative_model.e03prototype.demo1;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * @author OldGj 2024/02/21
 * @version v1.0
 * @apiNote 测试类 - 测试原型模式克隆
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
//        Realizetype realizetype = new Realizetype();
//        Realizetype cloned = realizetype.clone();
//        System.out.println(cloned==realizetype);
//
//        User user = new User();
//        user.setAddress(new Address("beijing","shanghai"));
//
//        User user1 = new User();
//        BeanUtils.copyProperties(user,user1);
//
//        System.out.println(user == user1);
//        System.out.println(user.getAddress() == user1.getAddress()); // true 浅拷贝
//        User user = new User();
//        User o = (User) BeanUtils.cloneBean(user);
//        System.out.println(o==user);
//        System.out.println(user.getAddress()==o.getAddress()); // true 浅拷贝
        User user = new User();
        User clone = (User) user.clone();
        System.out.println(user == clone);
        System.out.println(user.getAddress() == clone.getAddress());
    }
}
