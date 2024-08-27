package com.itbaizhan.oop;

import java.util.Objects;

/*
*   测试Object
*   重写toString方法
*   重写equals方法
* */
public class TestObject extends Object{
    int id;
    String name;
    String pwd;

    /*@Override
    public  String toString() {  //重写toString方法
        return "用户名:"+name+" 密码:"+pwd;
    }*/

    public TestObject(String name, String pwd,int id) {
        this.name = name;
        this.pwd = pwd;
        this.id=id;
    }

    public static void main(String[] args) {
        /*TestObject t1 = new TestObject("郭家旗", "2022005946");
        System.out.println(t1.toString());
        System.out.println(t1);//默认调用toString()方法*/
        TestObject t1 = new TestObject("郭家旗","123456",5946);
        TestObject t2 = new TestObject("苏红润","654321",5946);
        System.out.println(t1.toString());
        System.out.println(t2.toString());
        System.out.println(t1.equals(t2));
    }

    /*@Override  //重写equals方法
    public boolean equals(Object o) {
        if (this == o) return true;                    //当id相等时，输出true
        if (o == null || getClass() != o.getClass()) return false;
        TestObject that = (TestObject) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }*/

    @Override//重写equals方法
    public boolean equals(Object o) {           //当ID name pwd都相等时，才返回true
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestObject that = (TestObject) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(pwd, that.pwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, pwd);
    }
}
