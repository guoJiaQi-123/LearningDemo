package com.itbaizhan.mysecurity.domain;

import lombok.Data;

@Data
public class Users {
    private Integer uid;
    private String username;
    private String password;
    private String phone;

}
