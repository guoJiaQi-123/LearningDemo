package com.itbaizhan.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @version v1.0
 * @author OldGj 2024/04/24
 * @apiNote 统一结果返回集
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {

    // 状态码
    private Integer code;
    // 返回内容
    private String message;
    // 返回数据
    private T date;

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
