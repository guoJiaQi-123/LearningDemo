package com.bjsxt.lombok;


import lombok.Data;
import lombok.ToString;

//重写equals toString hashCode getter setter
@Data
public class Person {
    private int id;

    @ToString.Exclude //如果不想在toSting中输出，加这个注释
    private String name;

}
