package com.bjsxt.service;

public class PeopleService {

    public String insert(String name,int age){
        System.out.println("insert:age:"+age+" name:"+name);
//        int i=5/0;
        return age+","+name;
    }

}
