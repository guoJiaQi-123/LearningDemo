package com.itbaizhan.myshiro.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Permission implements Serializable {
    private Integer pid;

    private String permissionName;

    private String url;

}
