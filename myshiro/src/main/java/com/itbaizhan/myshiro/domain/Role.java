package com.itbaizhan.myshiro.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Role implements Serializable {
    private Integer rid;
    private String roleName;
    private String roleDesc;
}
