package com.itbaizhan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * 统一返回结果集
 * @param <T>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {

    // 返回结果编码
    private Integer code;
    // 返回结果描述
    private String message;
    // 数据
    private T data;


    private CommonResult(Integer code,String message){
        this(code,message,null);
    }
}