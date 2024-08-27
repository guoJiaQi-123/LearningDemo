package com.itbaizhan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/**
 * 用户模型
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    //用户id
    private Long id;
    // 用户名字
    private String name;
}
