package com.itbaizhan.mysecurity.domain;

import lombok.Data;

@Data
public class Permission {
    private Integer pid;
    private String permissionName;
    private String url;
}
