package com.itbaizhan.lombok1.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class User {
    private static String userid;
    private String username;
    private String password;

}
