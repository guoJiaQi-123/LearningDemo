package com.itbaizhan.oop.encapsulasion.b;

public class Test {
    public static void main(String[] args) {
        User u = new User(1000,"郭家旗",true);
        System.out.println(u.getId());
        System.out.println(u.getName());
        System.out.println(u.isMan());
    }


}
