package com.itbaizhan.myshiro.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Users implements Serializable {
    private Integer uid;
    private String username;
    private String password;
    private String salt;
}
