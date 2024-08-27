package com.itbaizhan.SpingBootDemo1.controller;

import com.itbaizhan.SpingBootDemo1.domain.Address;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ConfigurationProperties(prefix = "user")
public class YmlController2 {
    private String name;
    private int age;
    private List<String> game;
    private List<Address> address;

    @RequestMapping("/yml2")
    @ResponseBody
    public String yml2(){
        System.out.println(name);
        System.out.println(age);
        System.out.println(game);
        System.out.println(address);
        return "hello springboot";
    }

    @Override
    public String toString() {
        return "YmlController2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", game=" + game +
                ", address=" + address +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getGame() {
        return game;
    }

    public void setGame(List<String> game) {
        this.game = game;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }
}
