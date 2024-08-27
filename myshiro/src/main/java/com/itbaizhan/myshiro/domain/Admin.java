package com.itbaizhan.myshiro.domain;

import lombok.Data;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class Admin implements Serializable {
    private Integer id;
    private String name;
    private String password;
}