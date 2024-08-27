package com.itbaizhan;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    //用户ID
    private Long id;
    //用户名
    private String name;
    //用户年纪
    private Integer age;

}
