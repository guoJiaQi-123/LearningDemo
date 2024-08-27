package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/03
 *本类内容：自定义异常
 */

public class TestMyException {

    public static void main(String[] args) {
        person p=new person();
        try {
            p.setAge(9);
            p.setName("郭家旗");
        } catch (IllegalAgeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(p.toString());
    }
}
class person{
    private String name;
    private int age;
    public void setName(String name){
        this.name=name;
    }
    public void setAge(int age)throws Exception{
        if(age<0){
            throw new IllegalAgeException("人的年龄不应该是负数");
        }
        this.age=age;
    }
    public String toString(){
        return "name="+name+"\t"+"age="+age;
    }
}